package com.wuhan.sp.jxkh.biz.views;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.QuTodo;
import com.wuhan.sp.jxkh.mapper.views.QuTodoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 区待办
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QuTodoBiz extends BaseBiz<QuTodoMapper, QuTodo> {

}
