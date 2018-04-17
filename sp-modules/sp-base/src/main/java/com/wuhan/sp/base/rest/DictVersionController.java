package com.wuhan.sp.base.rest;

import com.wuhan.sp.base.biz.DictVersionBiz;
import com.wuhan.sp.base.entity.DictVersion;
import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.common.rest.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@RestController
@RequestMapping("dict")
public class DictVersionController extends BaseController<DictVersionBiz, DictVersion> {

  @Autowired
  private DictVersionBiz dictVersionBiz;

  @RequestMapping(value = "/version/check", method = RequestMethod.POST)
  public ObjectRestResponse<HashMap<String,String>> checkDictVersion(@RequestBody HashMap<String,String> mapDictVersion) {
    HashMap<String,String> dicts = dictVersionBiz.checkDictVersion(mapDictVersion);
    return new ObjectRestResponse<HashMap<String,String>>().data(dicts);
  }

  @RequestMapping(value = "/{code}/download")
  public ObjectRestResponse<HashMap<String,String>> downloadDict(@PathVariable String code) {
    Object dv = dictVersionBiz.downloadDictByCode(code);
    return new ObjectRestResponse<Object>().data(dv);
  }
}
