
package com.wuhan.oss.cloud;

import com.wuhan.config.CloudStorageConfig;
import com.wuhan.oss.constants.OSSConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Component
public class OSSFactory {
    @Autowired
    private CloudStorageConfig config;

    public CloudStorageService build() {
        if (config.getType().equals(OSSConstant.TYPE_QINIU)) {
            return new QiniuCloudStorageService(config);
        } else if (config.getType().equals(OSSConstant.TYPE_ALIYUN)) {
            return new AliyunCloudStorageService(config);
        } else if (config.getType().equals(OSSConstant.TYPE_QCLOUD)) {
            return new QcloudCloudStorageService(config);
        }
        return null;
    }

}
