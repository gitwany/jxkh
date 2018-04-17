package com.wuhan.sp.jxkh.biz.zd;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.Kpdx;
import com.wuhan.sp.jxkh.mapper.zd.KpdxMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 考评总项（二级字典）
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class KpdxBiz extends BaseBiz<KpdxMapper, Kpdx> {

}
