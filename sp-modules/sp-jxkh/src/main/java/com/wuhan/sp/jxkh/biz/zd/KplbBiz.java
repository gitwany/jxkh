package com.wuhan.sp.jxkh.biz.zd;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.Kplb;
import com.wuhan.sp.jxkh.mapper.zd.KplbMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 考评类别（一级字典）
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class KplbBiz extends BaseBiz<KplbMapper, Kplb> {

}
