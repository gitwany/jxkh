package com.wuhan.sp.jxkh.rest.zd;


import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.jxkh.biz.zd.KpdxBiz;
import com.wuhan.sp.jxkh.biz.zd.KplbBiz;
import com.wuhan.sp.jxkh.biz.zd.KpxxBiz;
import com.wuhan.sp.jxkh.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 考评字典
 */
@Controller
@RequestMapping("kpzd")
public class KpzdController {

    @Autowired
    protected KplbBiz kplbBiz;

    @Autowired
    protected KpdxBiz kpdxBiz;

    @Autowired
    protected KpxxBiz kpxxBiz;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse getAll() {
        List<Kplb> kplbList = kplbBiz.selectListAll();
        List<Kpzd> kpzdList = new ArrayList<Kpzd>();
        for (Kplb kplb : kplbList) {
            List<Kpdxzd> kpdxzdList = new ArrayList<Kpdxzd>();
            Example examplekplb = new Example(Kpdx.class);
            examplekplb.createCriteria().andCondition("ID IN (" + kplb.getKpdxs() + ")");
            List<Kpdx> kpdxs = kpdxBiz.selectByExample(examplekplb);
            for (Kpdx kpdx : kpdxs) {
                Kpdxzd kpdxzd = new Kpdxzd(kpdx.getId(), kpdx.getKplb());
                Example exampleKpxx = new Example(Kpxx.class);
                exampleKpxx.createCriteria().andCondition("KPLB = " + kplb.getId() + " AND KPDX = " + kpdx.getId());
                List<Kpxx> kpxxs = kpxxBiz.selectByExample(exampleKpxx);
                kpdxzd.setData(kpxxs);
                kpdxzdList.add(kpdxzd);
            }
            Kpzd kpzd = new Kpzd(kplb.getId(), kplb.getKplb(), kpdxzdList);
            kpzdList.add(kpzd);
        }
        return new ObjectRestResponse().data(kpzdList);
    }
}
