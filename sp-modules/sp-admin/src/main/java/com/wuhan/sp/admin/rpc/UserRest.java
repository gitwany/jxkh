package com.wuhan.sp.admin.rpc;

import com.ace.cache.annotation.Cache;
import com.wuhan.sp.admin.rpc.service.PermissionService;
import com.wuhan.sp.common.vo.PermissionInfo;
import com.wuhan.sp.common.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@RestController
@RequestMapping("api")
public class UserRest {
    @Autowired
    private PermissionService permissionService;

    @Cache(key="permission")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public @ResponseBody
    List<PermissionInfo> getAllPermission(){
        return permissionService.getAllPermission();
    }

    @Cache(key="permission:u{1}")
    @RequestMapping(value = "/user/un/{usercode}/permissions", method = RequestMethod.GET)
    public @ResponseBody List<PermissionInfo> getPermissionByUsercode(@PathVariable("usercode") String usercode){
        return permissionService.getPermissionByUsercode(usercode);
    }

    @RequestMapping(value = "/user/validate", method = RequestMethod.POST)
    public @ResponseBody
    UserInfo validate(String usercode, String password){
        return permissionService.validate(usercode,password);
    }


}
