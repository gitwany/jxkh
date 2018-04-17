package com.wuhan.sp.jxkh.rest.zd;

import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.zd.XzqhJdBiz;
import com.wuhan.sp.jxkh.entity.XzqhJd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 行政区划街道
 */
@Controller
@RequestMapping("xzqhjd")
public class XzqhJdController extends BaseController<XzqhJdBiz, XzqhJd> {
}
