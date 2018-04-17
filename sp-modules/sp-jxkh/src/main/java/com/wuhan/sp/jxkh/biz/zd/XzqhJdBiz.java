package com.wuhan.sp.jxkh.biz.zd;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.XzqhJd;
import com.wuhan.sp.jxkh.mapper.zd.XzqhJdMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 街道行政区划
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class XzqhJdBiz extends BaseBiz<XzqhJdMapper, XzqhJd> {
}
