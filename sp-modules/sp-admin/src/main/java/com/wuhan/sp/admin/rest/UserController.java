package com.wuhan.sp.admin.rest;

import com.wuhan.sp.admin.biz.UserBiz;
import com.wuhan.sp.admin.entity.User;
import com.wuhan.sp.admin.rpc.service.PermissionService;
import com.wuhan.sp.admin.vo.AppUser;
import com.wuhan.sp.admin.vo.FrontUser;
import com.wuhan.sp.admin.vo.MenuTree;
import com.wuhan.sp.common.exception.BaseException;
import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.common.rest.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz,User> {

    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private PermissionService permissionService;
    @RequestMapping(value = "/front/info", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse getUserInfo(String token,HttpServletRequest request) throws Exception {
        if(token ==null || token.isEmpty())
            token=request.getHeader(tokenHeader);
        FrontUser userInfo = permissionService.getUserInfo(token);
        if(userInfo==null) {
            throw new BaseException("获取用户参数失败",401);
        } else {
            return new ObjectRestResponse<FrontUser>().data(userInfo);
        }
    }

    @RequestMapping(value = "/app/info", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse getAppUserInfo(String token,HttpServletRequest request) throws Exception {
        if(token ==null || token.isEmpty())
            token=request.getHeader(tokenHeader);
        AppUser userInfo = permissionService.getAppUserInfo(token);
        if(userInfo==null) {
            throw new BaseException("获取用户参数失败",401);
        } else {
            return new ObjectRestResponse<AppUser>().data(userInfo);
        }
    }

    @RequestMapping(value = "/front/menus", method = RequestMethod.GET)
    public @ResponseBody
    List<MenuTree> getMenusByUsercode(String token) throws Exception {
        return permissionService.getMenusByUsercode(token);
    }
}
