package com.wuhan.sp.admin.vo;

import com.wuhan.sp.common.vo.TreeNode;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
public class GroupTree extends TreeNode {
    String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
