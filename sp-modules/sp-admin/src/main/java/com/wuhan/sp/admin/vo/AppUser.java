package com.wuhan.sp.admin.vo;

import com.wuhan.sp.common.vo.Module;
import com.wuhan.sp.common.vo.PermissionInfo;
import lombok.Data;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Data
public class AppUser {
    public String usercode;
    public String username;
    public String deptcode;
    public String deptname;
    private String description;
    private String image;
    private List<Module> modules;
}
