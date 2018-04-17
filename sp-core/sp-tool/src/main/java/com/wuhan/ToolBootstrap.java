
package com.wuhan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@SpringBootApplication
@EnableEurekaClient
public class ToolBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ToolBootstrap.class).web(true).run(args);
    }

}
