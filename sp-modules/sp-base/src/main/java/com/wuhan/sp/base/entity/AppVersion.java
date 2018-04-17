package com.wuhan.sp.base.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "base_dict_version")
@Data
public class AppVersion {
    @Id
    private Integer id;

    private String dictcode;

    private String dictname;

    private String sql;

    private String version;

}