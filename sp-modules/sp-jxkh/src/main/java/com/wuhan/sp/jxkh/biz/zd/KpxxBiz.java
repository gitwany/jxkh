package com.wuhan.sp.jxkh.biz.zd;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.Kpxx;
import com.wuhan.sp.jxkh.mapper.zd.KpxxMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 考评细项（三级字典）
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class KpxxBiz extends BaseBiz<KpxxMapper, Kpxx> {

}
