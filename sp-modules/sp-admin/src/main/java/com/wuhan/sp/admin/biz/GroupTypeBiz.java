package com.wuhan.sp.admin.biz;

import org.springframework.stereotype.Service;

import com.wuhan.sp.admin.entity.GroupType;
import com.wuhan.sp.admin.mapper.GroupTypeMapper;
import com.wuhan.sp.common.biz.BaseBiz;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper,GroupType> {
}
