package com.wuhan.sp.jxkh.rest.wtzg;
import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.common.rest.BaseController;
import com.wuhan.sp.jxkh.biz.wtzg.WtsbBiz;
import com.wuhan.sp.jxkh.entity.Wtsb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 问题上报
 */
@Controller
@RequestMapping("wtsb")
public class WtsbController extends BaseController<WtsbBiz, Wtsb> {

    @Autowired
    private WtsbBiz wtsbBiz;

    @ResponseBody
    @RequestMapping(value = "/wtcj2", method = RequestMethod.POST)
    public ObjectRestResponse wtcj(Wtsb wtsb, @RequestParam("Photos") MultipartFile[] files, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        return wtsbBiz.wtcj(wtsb, files, request);
    }

    @ResponseBody
    @RequestMapping(value = "/wtcj", method = RequestMethod.POST)
    public ObjectRestResponse wtcj2(Wtsb wtsb, @RequestParam(value = "Photos", required = false) MultipartFile[] files, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        baseBiz.insertSelective(wtsb);
        int id = wtsb.getId();

        List<String> fileUrlList = new ArrayList<String>(); //用来保存文件路径，用于页面回显用
        String path = "";
        String url = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datepath = sdf.format(new Date()) + "\\";

        // 先判断文件files不为空
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) { //循环遍历，取出单个文件，下面的操作和单个文件就一样了
                if (!file.isEmpty()) { //这个判断必须加上
                    String fileName = file.getOriginalFilename();// 获得原始文件名
                    String prefix = fileName.substring(fileName.lastIndexOf("."));// 获取文件名后缀
                    String pathRoot = "D:\\Pic\\xzqtp\\";
                    path = UUID.randomUUID().toString();
                    // 创建文件实例
                    File tempFile = new File(pathRoot + datepath + path + prefix); //文件保存路径为pathRoot + path
                    if (!tempFile.getParentFile().exists()) { // 这个判断必须加上
                        tempFile.getParentFile().mkdirs();
                        System.out.print(tempFile.getParentFile());
                    }
                    try {
                        file.transferTo(tempFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    fileUrlList.add(pathRoot + datepath + path + prefix);
                }
            }
        }
        Wtsb wtsbupd = baseBiz.selectById(id);
        for (String str : fileUrlList) {
            url = url + str + ",";
        }
        wtsbupd.setZghzp(url);
        baseBiz.updateSelectiveById(wtsbupd);
        return new ObjectRestResponse().data(baseBiz.selectById(id));
    }

    @ResponseBody
    @RequestMapping(value = "/wtxz", method = RequestMethod.POST)
    public ObjectRestResponse wtxz(Wtsb wtsb, @RequestParam("Photos") MultipartFile[] files, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        List<String> fileUrlList = new ArrayList<String>(); //用来保存文件路径，用于页面回显用
        String path = "";
        String url = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datepath = sdf.format(new Date()) + "\\";

        // 先判断文件files不为空
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) { //循环遍历，取出单个文件，下面的操作和单个文件就一样了
                if (!file.isEmpty()) { //这个判断必须加上
                    String fileName = file.getOriginalFilename();// 获得原始文件名
                    String prefix = fileName.substring(fileName.lastIndexOf("."));// 获取文件名后缀
                    String pathRoot = "D:\\Pic\\xztp\\";
                    path = UUID.randomUUID().toString();
                    // 创建文件实例
                    File tempFile = new File(pathRoot + datepath + path + prefix); //文件保存路径为pathRoot + path
                    if (!tempFile.getParentFile().exists()) { // 这个判断必须加上
                        tempFile.getParentFile().mkdirs();
                        System.out.print(tempFile.getParentFile());
                    }
                    try {
                        file.transferTo(tempFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    fileUrlList.add(path);
                }
            }
        }
        for (String str : fileUrlList) {
            url = url + str + ",";
        }
        wtsb.setZghzp(url);
        baseBiz.updateSelectiveById(wtsb);
        return new ObjectRestResponse().data(baseBiz.selectById(wtsb.getId()));
    }

    @ResponseBody
    @RequestMapping(value = "/xzwc", method = RequestMethod.POST)
    public ObjectRestResponse xzwc(Wtsb wtsb, @RequestParam("Photos") MultipartFile[] files, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        List<String> fileUrlList = new ArrayList<String>(); //用来保存文件路径，用于页面回显用
        String path = "";
        String url = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datepath = sdf.format(new Date()) + "\\";

        // 先判断文件files不为空
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) { //循环遍历，取出单个文件，下面的操作和单个文件就一样了
                if (!file.isEmpty()) { //这个判断必须加上
                    String fileName = file.getOriginalFilename();// 获得原始文件名
                    String prefix = fileName.substring(fileName.lastIndexOf("."));// 获取文件名后缀
                    String pathRoot = "D:\\Pic\\xzwc\\";
                    path = UUID.randomUUID().toString();
                    // 创建文件实例
                    File tempFile = new File(pathRoot + datepath + path + prefix); //文件保存路径为pathRoot + path
                    if (!tempFile.getParentFile().exists()) { // 这个判断必须加上
                        tempFile.getParentFile().mkdirs();
                        System.out.print(tempFile.getParentFile());
                    }
                    try {
                        file.transferTo(tempFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    fileUrlList.add(path);
                }
            }
        }
        for (String str : fileUrlList) {
            url = url + str + ",";
        }
        wtsb.setZghzp(url);
        baseBiz.updateSelectiveById(wtsb);
        return new ObjectRestResponse().data(baseBiz.selectById(wtsb.getId()));
    }

}