package com.wuhan.sp.jxkh.biz.wtzg;

import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.jxkh.entity.Wtsb;
import com.wuhan.sp.jxkh.feign.IWtProcessService;
import com.wuhan.sp.jxkh.mapper.wtzg.WtsbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 问题上报
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WtsbBiz extends BaseBiz<WtsbMapper, Wtsb> {

    @Autowired
    private WtsbBiz wtsbBiz;

    @Autowired
    private IWtProcessService wtProcessService;

    public ObjectRestResponse wtcj(Wtsb wtsb, MultipartFile[] files, HttpServletRequest request) {
        wtsbBiz.insertSelective(wtsb);
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
        Wtsb wtsbupd = wtsbBiz.selectById(id);
        for (String str : fileUrlList) {
            url = url + str + ",";
        }
        wtsbupd.setZghzp(url);
        wtsbBiz.updateSelectiveById(wtsbupd);
        int key = id;

        wtProcessService.start(String.valueOf(id), null);
        return new ObjectRestResponse().data(wtsbBiz.selectById(id));
    }

}
