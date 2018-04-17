package com.wuhan.sp.base.biz;

import com.alibaba.fastjson.JSON;
import com.wuhan.sp.base.config.RedisCacheUtil;
import com.wuhan.sp.base.constant.Constant;
import com.wuhan.sp.base.entity.AppVersion;
import com.wuhan.sp.base.entity.DictVersion;
import com.wuhan.sp.base.mapper.AppVersionMapper;
import com.wuhan.sp.base.mapper.DictVersionMapper;
import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.common.exception.BaseException;
import com.wuhan.sp.common.util.Utils;
import org.apache.ibatis.javassist.bytecode.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AppVersionBiz extends BaseBiz<AppVersionMapper,AppVersion> {

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    public HashMap<String,String> getLatestAppVersion() {
        HashMap<String,String> map = new HashMap<String,String>();
        //String latest = redisCacheUtil.getCacheObject(Constant.APPVERSION_KEY).toString();
        map.put("version","20180415");
        return map;
    }


}
