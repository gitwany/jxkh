package com.wuhan.sp.workflow;

import com.wuhan.sp.workflow.biz.WtsbProcessBiz;
import com.wuhan.sp.workflow.entity.Wtsb;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private HistoryService historyService;

    //流程引擎（核心对象）
    @Autowired
    private ProcessEngine processEngine;


    //部署流程定义
    @Test
    public void deployementProcessDefinition(){
        Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                .createDeployment()//创建部署对象
                .name("问题处理流程")//声明流程的名称
                .addClasspathResource("processes/process1.bpmn20.bpmn")//加载资源文件，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());
    }


   @Test
   public void TestStartProcess() {

   	   //开启任务
	   Map<String, Object> variables = new HashMap<String, Object>();
	   variables.put("user", "admin");
	   String businessKey ="111111";
	   runtimeService.startProcessInstanceByKey("process1", businessKey,variables);

       List<Task> taskList = taskService.createTaskQuery()
               .processInstanceBusinessKey(businessKey).taskAssignee("admin").
                       taskName("问题上报").orderByTaskCreateTime().desc().active().list();

	   //完成任务
	   String taskId=taskList.get(0).getId();
	   String user="admin";
	   taskService.claim(taskId, user);
       Map<String, Object> variables1 = new HashMap<String, Object>();
       variables.put("group", "third");
       variables.put("kplb", "beijiexiaoxiang");
	   taskService.complete(taskId,variables);

	   //查询用户组待办任务
	   List<Task> list1=taskService.createTaskQuery().taskCandidateGroup("third").list();

    }
}
