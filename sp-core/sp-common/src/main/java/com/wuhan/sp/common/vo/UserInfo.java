package com.wuhan.sp.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Data
public class UserInfo implements Serializable{
    public String id;
    public String usercode;
    public String password;
    public String username;
    private String description;
    private String deptcode;
    private String deptname;
    private Date updTime;

}
