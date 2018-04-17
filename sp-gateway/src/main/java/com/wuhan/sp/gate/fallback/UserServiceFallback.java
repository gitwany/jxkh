package com.wuhan.sp.gate.fallback;

import com.wuhan.sp.common.vo.PermissionInfo;
import com.wuhan.sp.common.vo.UserInfo;
import com.wuhan.sp.gate.feign.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
@Slf4j
public class UserServiceFallback implements IUserService {
    @Override
    public List<PermissionInfo> getPermissionByUsercode(@PathVariable("usercode") String usercode) {
        log.error("调用{}异常{}","getPermissionByUsercode",usercode);
        return null;
    }

    @Override
    public List<PermissionInfo> getAllPermissionInfo() {
        log.error("调用{}异常","getPermissionByUsercode");
        return null;
    }

    @Override
    public UserInfo validate(@RequestParam("usercode") String usercode, @RequestParam("password") String password) {
        log.error("调用{}异常","validate");
        return null;
    }
}
