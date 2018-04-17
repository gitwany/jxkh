package com.wuhan.sp.workflow.biz;
import com.wuhan.sp.common.msg.BaseResponse;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * 问题上报
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WtsbProcessBiz {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    //流程引擎（核心对象）
    @Autowired
    private ProcessEngine processEngine;

    //部署流程定义
    public void deployementProcessDefinition(){
        Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                .createDeployment()//创建部署对象
                .name("问题处理流程")//声明流程的名称
                .addClasspathResource("processes/process1.bpmn20.bpmn")//加载资源文件，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());
    }


    public void start(String businessKey, HashMap<String,String> variables) {
        String userId=variables.get("userId");
        String groupId=variables.get("groupId");
        String kplb=variables.get("kplb");

        //开启任务
        Map<String, Object> variables1 = new HashMap<String, Object>();
        variables1.put("user", userId);
        runtimeService.startProcessInstanceByKey("process1", businessKey, variables1);

        List<Task> taskList = taskService.createTaskQuery()
                .processInstanceBusinessKey(businessKey).taskAssignee(userId).
                        taskName("问题上报").orderByTaskCreateTime().desc().active().list();

        //完成任务
        String taskId = taskList.get(0).getId();
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("group", groupId);
        variables2.put("kplb", kplb);
        taskService.complete(taskId, variables2);
    }

    public void third_wtxz(String taskId,HashMap<String,String> variables) {
        String userId=variables.get("userId");
        String groupId=variables.get("groupId");
        String kplb=variables.get("kplb");
        //完成任务
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("group", groupId);
        variables2.put("kplb", kplb);
        taskService.claim(taskId,userId);
        taskService.complete(taskId, variables2);
    }

    public void third_zhenggaishenhe(String taskId,HashMap<String,String> variables) {
        String userId=variables.get("userId");
        String groupId=variables.get("groupId");
        //完成任务
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("group", groupId);
        taskService.claim(taskId,userId);
        taskService.complete(taskId, variables2);
    }

    public void qu_fenpai(String taskId,HashMap<String,String> variables) {
        String userId=variables.get("userId");
        String groupId=variables.get("groupId");
        //完成任务
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("group", groupId);
        taskService.claim(taskId,userId);
        taskService.complete(taskId, variables2);
    }

    public void jiedao_fenpai(String businessKey,String taskId,HashMap<String,String> variables) {
        String userId1=variables.get("userId");
        String userId2=variables.get("userId2");
        String groupId=variables.get("groupId");

        //完成签收任务
        Map<String, Object> variables1 = new HashMap<String, Object>();
        variables1.put("user",userId1);
        variables1.put("status","fenpai");
        taskService.claim(taskId,userId1);
        taskService.complete(taskId, variables1);

        //完成分派任务-分派任务到个人
        List<Task> taskList = taskService.createTaskQuery()
                .processInstanceBusinessKey(businessKey).taskAssignee(variables1.get("user").toString()).
                        taskName("问题上报").orderByTaskCreateTime().desc().active().list();
        String taskId2 = taskList.get(0).getId();
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("user",userId2);
        taskService.complete(taskId2, variables2);
    }


    public void jiedao_xiuzheng(String businessKey,String taskId,HashMap<String,String> variables) {
        String userId1=variables.get("userId");
        String groupId=variables.get("groupId");

        //完成签收任务
        Map<String, Object> variables1 = new HashMap<String, Object>();
        variables1.put("user",userId1);
        variables1.put("status","xiuzheng");
        taskService.claim(taskId,userId1);
        taskService.complete(taskId, variables1);

        //完成修正任务-任务到第三方
        List<Task> taskList = taskService.createTaskQuery()
                .processInstanceBusinessKey(businessKey).taskAssignee(variables1.get("user").toString()).
                        taskName("问题上报").orderByTaskCreateTime().desc().active().list();
        String taskId2 = taskList.get(0).getId();
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("group",groupId);
        taskService.complete(taskId2, variables2);
    }

    public void jiedao_zhenggai(String businessKey,String taskId,HashMap<String,String> variables) {
        String userId1=variables.get("userId");
        String userId2=variables.get("userId2");
        String groupId=variables.get("groupId");

        //完成签收任务-任务到提交整改
        Map<String, Object> variables1 = new HashMap<String, Object>();
        variables1.put("user",userId2);
        variables1.put("status","zhenggai");
        taskService.claim(taskId,userId1);
        taskService.complete(taskId, variables1);

        //完成整改任务--任务到整改审核
        List<Task> taskList = taskService.createTaskQuery()
                .processInstanceBusinessKey(businessKey).taskAssignee(variables1.get("user").toString()).
                        taskName("问题上报").orderByTaskCreateTime().desc().active().list();
        String taskId2 = taskList.get(0).getId();
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("group",groupId);
        taskService.complete(taskId2, variables2);
    }

    public void zgr_zhenggai(String businessKey,String taskId,HashMap<String,String> variables) {
        String userId1=variables.get("userId");
        String userId2=variables.get("userId2");
        String groupId=variables.get("groupId");

        //完成签收任务-任务到整改提交
        Map<String, Object> variables1 = new HashMap<String, Object>();
        variables1.put("user",userId1);
        variables1.put("status","zhenggai");
        taskService.claim(taskId,userId1);
        taskService.complete(taskId, variables1);

        //完成整改任务--任务到整改审核
        List<Task> taskList = taskService.createTaskQuery()
                .processInstanceBusinessKey(businessKey).taskAssignee(variables1.get("user").toString()).
                        taskName("问题上报").orderByTaskCreateTime().desc().active().list();
        String taskId2 = taskList.get(0).getId();
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("group",groupId);
        taskService.complete(taskId2, variables2);
    }

    public void zgr_reject(String businessKey,String taskId,HashMap<String,String> variables) {
        String userId1=variables.get("userId");
        String groupId=variables.get("groupId");

        //完成签收任务-任务到退回申请
        Map<String, Object> variables1 = new HashMap<String, Object>();
        variables1.put("user",userId1);
        variables1.put("status","zhenggai");
        taskService.claim(taskId,userId1);
        taskService.complete(taskId, variables1);

        //完成退回任务--任务到街道签收
        List<Task> taskList = taskService.createTaskQuery()
                .processInstanceBusinessKey(businessKey).taskAssignee(variables1.get("user").toString()).
                        taskName("问题上报").orderByTaskCreateTime().desc().active().list();
        String taskId2 = taskList.get(0).getId();
        Map<String, Object> variables2 = new HashMap<String, Object>();
        variables2.put("group",groupId);
        taskService.complete(taskId2, variables2);
    }

}
