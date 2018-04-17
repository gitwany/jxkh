package com.wuhan.sp.base.biz;

import com.alibaba.fastjson.JSON;
import com.wuhan.sp.base.config.RedisCacheUtil;
import com.wuhan.sp.base.constant.Constant;
import com.wuhan.sp.base.entity.DictVersion;
import com.wuhan.sp.base.mapper.DictVersionMapper;
import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.common.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictVersionBiz extends BaseBiz<DictVersionMapper,DictVersion> {

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    public HashMap<String,String> checkDictVersion(HashMap<String,String> mapDict) {
        HashMap<String,String> mapDownload = new HashMap<String,String>();
        Set set = mapDict.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            String code = entry.getKey().toString().toLowerCase();
            String version1 = (String) entry.getValue();
            String version2 = redisCacheUtil.getCacheMap(Constant.DICT_KEY+code).get("version").toString();
            boolean bDownload=false;
            if (version1 == null) {
                bDownload=true;
            } else {
                if (!version1.equals(version2)) {
                    bDownload=true;
                }
            }
            if(bDownload)
            {
                mapDownload.put(code,version2);
            }
        }
        return mapDownload;
    }

    public Object downloadDictByCode(String dictcode) {
        HashMap<String,String> dv = new HashMap<String,String>();
        Object map = redisCacheUtil.getCacheMap(Constant.DICT_KEY + dictcode.toLowerCase()).get("content");
        if (map == null)
            throw new BaseException("更新字典失败" + dictcode);
        return map;
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void syncDict() {
        try {
            List<DictVersion> listDict = mapper.selectAll();
            List<DictVersion> dictDownload = checkDictVersion2(listDict);

            for (DictVersion dv : dictDownload) {
                String dictcode = dv.getDictcode().toLowerCase();
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("dictcode", dv.getDictcode());
                map.put("version", dv.getVersion());
                String sql = dv.getSqlstr();
                List<LinkedHashMap<String, String>> dicts = mapper.selectDictsBySql(sql);
                map.put("content", dicts);
                redisCacheUtil.setCacheMap(Constant.DICT_KEY + dictcode, map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DictVersion> checkDictVersion2(List<DictVersion> listDict) {
        List<DictVersion> list = new ArrayList<>();
        for (DictVersion dv : listDict) {
            String version1 = dv.getVersion();
            String sql1 = dv.getSqlstr();
            String code = dv.getDictcode();
            String version2="";
            Map<String,String> map = redisCacheUtil.getCacheMap(Constant.DICT_KEY+code);
            if(map!=null)
            {
                version2=map.get("version");
            }
            boolean bDownload=false;
            if (version2 == null) {
                bDownload=true;
            } else {
                if (version1!=null && !version1.equals(version2)) {
                    bDownload=true;
                }
            }
            if(bDownload)
            {
                list.add(dv);
            }
        }
        return list;
    }

}
