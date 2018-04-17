package com.wuhan.sp.base.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "base_dict_version")
@Data
public class DictVersion {
    @Id
    private Integer id;

    private String dictcode;

    private String dictname;

    private String sqlstr;

    private String version;

}