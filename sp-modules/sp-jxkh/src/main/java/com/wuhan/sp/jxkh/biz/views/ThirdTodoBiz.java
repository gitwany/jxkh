package com.wuhan.sp.jxkh.biz.views;


import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.jxkh.entity.ThirdTodo;
import com.wuhan.sp.jxkh.mapper.views.ThirdTodoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 第三方待办
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ThirdTodoBiz extends BaseBiz<ThirdTodoMapper, ThirdTodo> {
}
