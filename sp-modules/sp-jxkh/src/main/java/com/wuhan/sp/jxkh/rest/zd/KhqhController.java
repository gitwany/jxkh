package com.wuhan.sp.jxkh.rest.zd;

import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.zd.KhqhBiz;
import com.wuhan.sp.jxkh.entity.Khqh;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 考核区划
 */
@Controller
@RequestMapping("khqh")
public class KhqhController extends BaseController<KhqhBiz, Khqh> {
}
