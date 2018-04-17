package com.wuhan.sp.admin.vo;

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
public class FrontUser {
    public String id;
    public String usercode;
    public String username;
    private String description;
    private String image;
    private List<PermissionInfo> menus;
    private List<PermissionInfo> elements;
}
