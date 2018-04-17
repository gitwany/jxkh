package com.wuhan.sp.workflow;

import com.ace.cache.EnableAceCache;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.activiti.engine.ProcessEngine;
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
@EnableScheduling
@EnableAceCache
@EnableTransactionManagement
@EnableSwagger2Doc

@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
})
public class WorkFlowBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(WorkFlowBootstrap.class).web(true).run(args);    }
}
