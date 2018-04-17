package com.wuhan.sp.base.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Dict {
    private String code;

    private String name;

    private String parent;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

}