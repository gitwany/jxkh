package com.wuhan.sp.jxkh.rest.zd;

import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.zd.ZcgdBiz;
import com.wuhan.sp.jxkh.entity.Zcgd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主次干道
 */
@Controller
@RequestMapping("zcgd")
public class ZcgdController extends BaseController<ZcgdBiz, Zcgd> {
}
