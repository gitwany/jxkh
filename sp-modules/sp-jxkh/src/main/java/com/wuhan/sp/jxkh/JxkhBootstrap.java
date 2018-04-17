package com.wuhan.sp.jxkh;

import com.ace.cache.EnableAceCache;
import com.spring4all.swagger.EnableSwagger2Doc;
//import org.activiti.engine.ProcessEngine;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients({"com.wuhan.sp.auth.client.feign"})
@EnableScheduling
@EnableAceCache
@EnableTransactionManagement
@MapperScan("com.wuhan.sp.jxkh.mapper")
@EnableSwagger2Doc

@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class,
     //   org.activiti.spring.boot.SecurityAutoConfiguration.class,
})
public class JxkhBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JxkhBootstrap.class).web(true).run(args);    }



}
