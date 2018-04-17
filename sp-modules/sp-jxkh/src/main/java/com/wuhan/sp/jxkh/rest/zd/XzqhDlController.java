package com.wuhan.sp.jxkh.rest.zd;

import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.zd.XzqhDlBiz;
import com.wuhan.sp.jxkh.entity.XzqhDl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 行政区划道路
 */
@Controller
@RequestMapping("xzqhdl")
public class XzqhDlController extends BaseController<XzqhDlBiz, XzqhDl> {
}
