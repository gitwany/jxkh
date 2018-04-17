package com.wuhan.sp.admin.biz;

import com.wuhan.sp.admin.entity.ResourceAuthority;
import com.wuhan.sp.admin.mapper.ResourceAuthorityMapper;
import com.wuhan.sp.common.biz.BaseBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper,ResourceAuthority> {
}
