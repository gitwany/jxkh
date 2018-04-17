package com.wuhan.sp.jxkh.biz.zd;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.Khqh;
import com.wuhan.sp.jxkh.mapper.zd.KhqhMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 考核区划
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class KhqhBiz extends BaseBiz<KhqhMapper, Khqh> {
}
