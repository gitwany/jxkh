package com.wuhan.sp.base.mapper;

import com.wuhan.sp.base.entity.DictVersion;
import tk.mybatis.mapper.common.Mapper;
import java.util.LinkedHashMap;
import java.util.List;

public interface DictVersionMapper extends Mapper<DictVersion> {
    public List<LinkedHashMap<String,String>> selectDictsBySql(String sql);
}