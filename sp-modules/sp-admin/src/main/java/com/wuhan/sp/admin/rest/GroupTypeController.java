package com.wuhan.sp.admin.rest;

import com.wuhan.sp.admin.biz.GroupTypeBiz;
import com.wuhan.sp.admin.entity.GroupType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuhan.sp.common.rest.BaseController;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Controller
@RequestMapping("groupType")
public class GroupTypeController extends BaseController<GroupTypeBiz,GroupType> {
//
//    @RequestMapping(value = "/page",method = RequestMethod.GET)
//    @ResponseBody
//    public TableResultResponse<Object> page(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1")int page, String name){
//        Example example = new Example(GroupType.class);
//        if(StringUtils.isNotBlank(name))
//            example.createCriteria().andLike("name", "%" + name + "%");
//        Page<Object> result = PageHelper.startPage(page, limit);
//        baseBiz.selectByExample(example);
//        return new TableResultResponse<Object>(result.getTotal(),result.getResult());
//    }

}
