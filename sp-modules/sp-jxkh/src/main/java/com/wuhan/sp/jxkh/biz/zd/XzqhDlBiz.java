package com.wuhan.sp.jxkh.biz.zd;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.XzqhDl;
import com.wuhan.sp.jxkh.mapper.zd.XzqhDlMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 道路行政区划
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class XzqhDlBiz extends BaseBiz<XzqhDlMapper, XzqhDl> {
}
