package com.wuhan.sp.jxkh.rest.zd;

import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.zd.KplbBiz;
import com.wuhan.sp.jxkh.entity.Kplb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 考评类别（一级字典）
 */
@Controller
@RequestMapping("kplb")
public class KplbController extends BaseController<KplbBiz, Kplb> {

}
