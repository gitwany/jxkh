package com.wuhan.sp.jxkh.rest.zd;

import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.zd.KpdxBiz;
import com.wuhan.sp.jxkh.entity.Kpdx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 考评类别（二级字典）
 */
@Controller
@RequestMapping("kpdx")
public class KpdxController extends BaseController<KpdxBiz, Kpdx> {

}
