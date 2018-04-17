package com.wuhan.sp.jxkh.rest.zd;

import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.zd.JdBiz;
import com.wuhan.sp.jxkh.entity.Jd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 街道
 */
@Controller
@RequestMapping("jd")
public class JdController extends BaseController<JdBiz, Jd> {
}
