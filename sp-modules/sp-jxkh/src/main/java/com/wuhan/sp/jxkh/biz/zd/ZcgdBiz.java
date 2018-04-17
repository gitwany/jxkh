package com.wuhan.sp.jxkh.biz.zd;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.Zcgd;
import com.wuhan.sp.jxkh.mapper.zd.ZcgdMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 主次干道
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ZcgdBiz extends BaseBiz<ZcgdMapper, Zcgd> {
}
