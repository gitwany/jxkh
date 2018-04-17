package com.wuhan.sp.admin.rpc.service;

import com.wuhan.sp.admin.biz.ElementBiz;
import com.wuhan.sp.admin.biz.MenuBiz;
import com.wuhan.sp.admin.biz.UserBiz;
import com.wuhan.sp.admin.config.JwtTokenUtil;
import com.wuhan.sp.admin.constant.AdminCommonConstant;
import com.wuhan.sp.admin.entity.Element;
import com.wuhan.sp.admin.entity.Menu;
import com.wuhan.sp.admin.entity.User;
import com.wuhan.sp.admin.vo.AppUser;
import com.wuhan.sp.admin.vo.FrontUser;
import com.wuhan.sp.admin.vo.MenuTree;
import com.wuhan.sp.common.constant.CommonConstants;
import com.wuhan.sp.common.exception.BaseException;
import com.wuhan.sp.common.util.TreeUtil;
import com.wuhan.sp.common.vo.Module;
import com.wuhan.sp.common.vo.PermissionInfo;
import com.wuhan.sp.common.vo.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
public class PermissionService {
    @Autowired
    private UserBiz userBiz;
    @Autowired
    private MenuBiz menuBiz;
    @Autowired
    private ElementBiz elementBiz;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public UserInfo getUserByUsercode(String usercode) {
        UserInfo info = new UserInfo();
        User user = userBiz.getUserByUsercode(usercode);
        BeanUtils.copyProperties(user, info);
        info.setId(user.getId().toString());
        return info;
    }

    public UserInfo validate(String usercode,String password){
        UserInfo info = new UserInfo();
        User user = userBiz.getUserByUsercode(usercode);
        if(user==null)
        {
            throw new BaseException("用户不存在");
        }
        if (encoder.matches(password, user.getPassword())) {
            BeanUtils.copyProperties(user, info);
            info.setId(user.getId().toString());
        }
        return info;
    }

    public List<PermissionInfo> getAllPermission() {
        List<Menu> menus = menuBiz.selectListAll();
        List<PermissionInfo> result = new ArrayList<PermissionInfo>();
        PermissionInfo info = null;
        menu2permission(menus, result);
        List<Element> elements = elementBiz.getAllElementPermissions();
        element2permission(result, elements);
        return result;
    }

    private void menu2permission(List<Menu> menus, List<PermissionInfo> result) {
        PermissionInfo info;
        for (Menu menu : menus) {
            if (StringUtils.isBlank(menu.getHref())) {
                menu.setHref("/" + menu.getCode());
            }
            info = new PermissionInfo();
            info.setCode(menu.getCode());
            info.setType(AdminCommonConstant.RESOURCE_TYPE_MENU);
            info.setName(AdminCommonConstant.RESOURCE_ACTION_VISIT);
            String uri = menu.getHref();
            if (!uri.startsWith("/")) {
                uri = "/" + uri;
            }
            info.setUri(uri);
            info.setMethod(AdminCommonConstant.RESOURCE_REQUEST_METHOD_GET);
            result.add(info
            );
            info.setMenu(menu.getTitle());
        }
    }

    public List<PermissionInfo> getPermissionByUsercode(String usercode) {
        User user = userBiz.getUserByUsercode(usercode);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        List<PermissionInfo> result = new ArrayList<PermissionInfo>();
        PermissionInfo info = null;
        menu2permission(menus, result);
        List<Element> elements = elementBiz.getAuthorityElementByUserId(user.getId() + "");
        element2permission(result, elements);
        return result;
    }

    private void element2permission(List<PermissionInfo> result, List<Element> elements) {
        PermissionInfo info;
        for (Element element : elements) {
            info = new PermissionInfo();
            info.setCode(element.getCode());
            info.setType(element.getType());
            info.setUri(element.getUri());
            info.setMethod(element.getMethod());
            info.setName(element.getName());
            info.setMenu(element.getMenuId());
            result.add(info);
        }
    }


    private List<MenuTree> getMenuTree(List<Menu> menus, int root) {
        List<MenuTree> trees = new ArrayList<MenuTree>();
        MenuTree node = null;
        for (Menu menu : menus) {
            node = new MenuTree();
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        }
        return TreeUtil.bulid(trees, root);
    }

    public FrontUser getUserInfo(String token) throws Exception {
        String usercode = jwtTokenUtil.getInfoFromToken(token).getUsercode();
        if (usercode == null) {
            return null;
        }
        UserInfo user = this.getUserByUsercode(usercode);
        FrontUser frontUser = new FrontUser();
        BeanUtils.copyProperties(user, frontUser);
        List<PermissionInfo> permissionInfos = this.getPermissionByUsercode(usercode);
        Stream<PermissionInfo> menus = permissionInfos.parallelStream().filter((permission) -> {
            return permission.getType().equals(CommonConstants.RESOURCE_TYPE_MENU);
        });
        frontUser.setMenus(menus.collect(Collectors.toList()));
        Stream<PermissionInfo> elements = permissionInfos.parallelStream().filter((permission) -> {
            return !permission.getType().equals(CommonConstants.RESOURCE_TYPE_MENU);
        });
        frontUser.setElements(elements.collect(Collectors.toList()));
        return frontUser;
    }

    public AppUser getAppUserInfo(String token) throws Exception {
        String usercode = jwtTokenUtil.getInfoFromToken(token).getUsercode();
        if (usercode == null) {
            return null;
        }
        UserInfo user = this.getUserByUsercode(usercode);
        AppUser appUser = new AppUser();
        appUser.setUsercode(user.getUsercode());
        appUser.setUsername(user.getUsername());
        appUser.setDeptcode(user.getDeptcode());
        appUser.setDeptname(user.getDeptname());
        appUser.setDescription(user.getDeptname());
        appUser.setImage("");
        List<Module> modules = new ArrayList<>();
        modules.add( new Module("MID_TEST1","功能1","app","",""));
        modules.add( new Module("MID_TEST2","功能2","app","",""));
        modules.add( new Module("MID_TEST3","功能3","app","",""));
        modules.add( new Module("MID_TEST4","功能4","app","",""));
        appUser.setModules(modules);
        return appUser;
    }

    public List<MenuTree> getMenusByUsercode(String token) throws Exception {
        String usercode = jwtTokenUtil.getInfoFromToken(token).getUsercode();
        if (usercode == null) {
            return null;
        }
        User user = userBiz.getUserByUsercode(usercode);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        return getMenuTree(menus,AdminCommonConstant.ROOT);
    }
}
