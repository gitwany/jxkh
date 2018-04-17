package com.wuhan.sp.workflow.rest;


import com.wuhan.sp.common.msg.BaseResponse;
import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.common.util.jwt.IJWTInfo;
import com.wuhan.sp.workflow.biz.WtsbProcessBiz;
import com.wuhan.sp.workflow.entity.Wtsb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 问题上报
 */
@Controller
@RequestMapping("process/wtsb")
public class WtsbProcessController {

    @Autowired
    private WtsbProcessBiz wtsbProcessBiz;

    //第三方问题上报开启流程
    @RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
    public BaseResponse start(@PathVariable("id") String id, @RequestBody HashMap<String, String> variables) throws Exception {
        wtsbProcessBiz.start(id,variables);
        return new BaseResponse();
    }

    //第三方问题修改重新分派
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/third_wtxz", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse third_wtxz(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables) {
        wtsbProcessBiz.third_wtxz(taskId,variables);
        return new BaseResponse();
    }

    //第三方整改审核
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/third_zhenggaishenhe", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse third_zhenggaishenhe(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables) {
        wtsbProcessBiz.third_zhenggaishenhe(taskId,variables);
        return new BaseResponse();
    }

    //区级分派
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/qu_fenpai", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse qu_fenpai(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables) {
        wtsbProcessBiz.qu_fenpai(taskId,variables);
        return new BaseResponse();
    }

    //街道分派任务
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/jiedao_fenpai", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse jiedao_fenpai(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables) {
        wtsbProcessBiz.jiedao_fenpai(bizId,taskId,variables);
        return new BaseResponse();
    }

    //街道提出修正申请
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/jiedao_xiuzheng", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse jiedao_xiuzheng(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables) {
        wtsbProcessBiz.jiedao_xiuzheng(bizId,taskId,variables);
        return new BaseResponse();
    }

    //街道直接整改
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/jiedao_zhenggai", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse jiedao_zhenggai(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables) {
        wtsbProcessBiz.jiedao_zhenggai(bizId,taskId,variables);
        return new BaseResponse();
    }

    //责任人提交整改
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/zgr_zhenggai", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse zgr_zhenggai(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables) {
        wtsbProcessBiz.zgr_zhenggai(bizId,taskId,variables);
        return new BaseResponse();
    }

    //责任人退回
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/zgr_reject", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse zgr_reject(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables) {
        wtsbProcessBiz.zgr_reject(bizId,taskId,variables);
        return new BaseResponse();
    }

}