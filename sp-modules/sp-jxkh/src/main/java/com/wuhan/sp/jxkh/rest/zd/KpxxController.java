package com.wuhan.sp.jxkh.rest.zd;

import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.zd.KpxxBiz;
import com.wuhan.sp.jxkh.entity.Kpxx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

/**
 * 考评细项（三级字典）
 */
@Controller
@RequestMapping("kpxx")
public class KpxxController extends BaseController<KpxxBiz, Kpxx> {

    @RequestMapping(value = "/getOne", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse list(int kplb, int kpdx) {
        Example example = new Example(Kpxx.class);
        example.createCriteria().andEqualTo("kplb", kplb);
        example.createCriteria().andEqualTo("kpdx", kpdx);
        return new ObjectRestResponse().data(baseBiz.selectByExample(example));
    }
}
