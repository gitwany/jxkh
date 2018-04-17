package com.wuhan.sp.jxkh.feign;


import com.wuhan.sp.common.msg.BaseResponse;
import com.wuhan.sp.jxkh.fallback.WtProcessServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@FeignClient(value = "sp-workflow",fallback = WtProcessServiceFallback.class)
public interface IWtProcessService {
    //第三方问题上报开启流程
    @RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
    public BaseResponse start(@PathVariable("id") String id, @RequestBody HashMap<String, String> variables);
    //第三方问题修改重新分派
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/third_wtxz", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse third_wtxz(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables);
    //第三方整改审核
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/third_zhenggaishenhe", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse third_zhenggaishenhe(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables);
    //区级分派
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/qu_fenpai", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse qu_fenpai(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables);
    //街道分派任务
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/jiedao_fenpai", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse jiedao_fenpai(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables);
    //街道提出修正申请
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/jiedao_xiuzheng", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse jiedao_xiuzheng(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables);
    //街道直接整改
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/jiedao_zhenggai", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse jiedao_zhenggai(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables);
    //责任人提交整改
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/zgr_zhenggai", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse zgr_zhenggai(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables);
    //责任人退回
    @RequestMapping(value = "/tasks/{bizId}/{taskId}/zgr_reject", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse zgr_reject(@PathVariable("bizId") String bizId,@PathVariable("taskId") String taskId, @RequestBody HashMap<String, String> variables);
}
