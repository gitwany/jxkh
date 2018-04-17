package com.wuhan.sp.jxkh.rest.views;

import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.jxkh.biz.views.JiedaoTodoBiz;
import com.wuhan.sp.jxkh.biz.views.QuTodoBiz;
import com.wuhan.sp.jxkh.entity.QuTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 待办查询
 */
@Controller
@RequestMapping("todo")
public class ToDoController {

    @Autowired
    private QuTodoBiz quTodoBiz;

    @Autowired
    private JiedaoTodoBiz jiedaoTodoBiz;

    @ResponseBody
    @RequestMapping(value = "/quTodo", method = RequestMethod.POST)
    public ObjectRestResponse quTodo(QuTodo quTodo) throws Exception {
        return new ObjectRestResponse().data(quTodoBiz.selectById(quTodo.getId()));
    }
}
