package com.wuhan.sp.jxkh.fallback;
import com.wuhan.sp.common.msg.BaseResponse;
import com.wuhan.sp.jxkh.feign.IWtProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
@Slf4j
public class WtProcessServiceFallback implements IWtProcessService {
    @Override
    public BaseResponse start(String bizId, HashMap<String, String> variables){
        log.error("调用{}异常{}","start",bizId);
        return null;
    }

    @Override
    public BaseResponse third_wtxz(String bizId,String taskId, HashMap<String, String> variables) {
        log.error("调用{}异常{}","third_wtxz",bizId);
        return null;
    }

    @Override
    public BaseResponse third_zhenggaishenhe(String bizId,String taskId, HashMap<String, String> variables) {
        log.error("调用{}异常{}","third_zhenggaishenhe",bizId);
        return null;
    }

    @Override
    public BaseResponse qu_fenpai(String bizId,String taskId, HashMap<String, String> variables) {
        log.error("调用{}异常{}","qu_fenpai",bizId);
        return null;
    }

    @Override
    public BaseResponse jiedao_fenpai(String bizId,String taskId, HashMap<String, String> variables) {
        log.error("调用{}异常{}","jiedao_fenpai",bizId);
        return null;
    }
    @Override
    public BaseResponse jiedao_xiuzheng(String bizId,String taskId, HashMap<String, String> variables) {
        log.error("调用{}异常{}","jiedao_xiuzheng",bizId);
        return null;
    }
    @Override
    public BaseResponse jiedao_zhenggai(String bizId,String taskId, HashMap<String, String> variables) {
        log.error("调用{}异常{}","jiedao_zhenggai",bizId);
        return null;
    }
    @Override
    public BaseResponse zgr_zhenggai(String bizId,String taskId, HashMap<String, String> variables) {
        log.error("调用{}异常{}","zgr_zhenggai",bizId);
        return null;
    }
    @Override
    public BaseResponse zgr_reject(String bizId,String taskId, HashMap<String, String> variables) {
        log.error("调用{}异常{}","zgr_reject",bizId);
        return null;
    }

}
