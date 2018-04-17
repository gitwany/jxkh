package com.wuhan.sp.base;

import com.ace.cache.EnableAceCache;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableScheduling
@EnableAceCache
@EnableTransactionManagement
@MapperScan("com.wuhan.sp.base.mapper")
@EnableSwagger2Doc
public class BaseBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BaseBootstrap.class).web(true).run(args);    }
}
