package com.wuhan.sp.gate.feign;

import com.wuhan.sp.common.vo.PermissionInfo;
import com.wuhan.sp.common.vo.UserInfo;
import com.wuhan.sp.gate.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@FeignClient(value = "sp-admin",fallback = UserServiceFallback.class)
public interface IUserService {
  @RequestMapping(value="/api/user/un/{usercode}/permissions",method = RequestMethod.GET)
  public List<PermissionInfo> getPermissionByUsercode(@PathVariable("usercode") String usercode);
  @RequestMapping(value="/api/permissions",method = RequestMethod.GET)
  List<PermissionInfo> getAllPermissionInfo();
  @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
  public UserInfo validate(@RequestParam("usercode") String usercode, @RequestParam("password") String password);
}
