package com.wuhan.sp.jxkh.biz.views;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.JiedaoTodo;
import com.wuhan.sp.jxkh.mapper.views.JiedaoTodoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 街道待办
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JiedaoTodoBiz extends BaseBiz<JiedaoTodoMapper, JiedaoTodo> {
    
}
