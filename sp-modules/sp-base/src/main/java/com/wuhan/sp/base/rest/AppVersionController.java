package com.wuhan.sp.base.rest;

import com.wuhan.sp.base.biz.AppVersionBiz;
import com.wuhan.sp.base.biz.DictVersionBiz;
import com.wuhan.sp.base.entity.AppVersion;
import com.wuhan.sp.base.entity.DictVersion;
import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.common.rest.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@RestController
@RequestMapping("app")
public class AppVersionController extends BaseController<AppVersionBiz, AppVersion> {

  @Autowired
  private AppVersionBiz appVersionBiz;

  @RequestMapping(value = "/version/latest")
  public ObjectRestResponse<HashMap<String, String>> checkAppVersion() {
    HashMap<String, String> versionMap = appVersionBiz.getLatestAppVersion();
    return new ObjectRestResponse<HashMap<String, String>>().data(versionMap);
  }

  @RequestMapping(value = "/{version}/download")
  public void downloadDict(@PathVariable String version, HttpServletResponse response) {
    response.setContentType("application/vnd.android.package-archive");
    response.setHeader("Content-disposition", "attachment;filename="+version+".apk");
    try {
      FileInputStream fis = new FileInputStream("d:/download/" + version+".apk");
      OutputStream os = response.getOutputStream();
      byte[] bytes = new byte[1024];
      int len = 0;
      while ((len = fis.read(bytes)) > 0) {
        os.write(bytes, 0, len);
      }
      fis.close();
      os.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
