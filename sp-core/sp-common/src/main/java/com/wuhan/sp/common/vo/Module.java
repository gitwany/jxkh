package com.wuhan.sp.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
public class Module implements Serializable{
    private String code;
    private String name;
    private String type;
    private String uri;
    private String icon;
}
