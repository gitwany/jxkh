package com.wuhan.sp.gate;

import com.wuhan.sp.gate.utils.DBLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.wuhan.sp.gate.feign"})
@EnableZuulProxy
@EnableScheduling
public class GateBootstrap {
    public static void main(String[] args) {
        DBLog.getInstance().start();
        SpringApplication.run(GateBootstrap.class, args);
    }
}
