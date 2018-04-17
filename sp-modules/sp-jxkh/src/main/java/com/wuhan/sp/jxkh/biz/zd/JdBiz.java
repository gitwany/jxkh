package com.wuhan.sp.jxkh.biz.zd;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.Jd;
import com.wuhan.sp.jxkh.mapper.zd.JdMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 街道
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JdBiz extends BaseBiz<JdMapper, Jd> {
}
