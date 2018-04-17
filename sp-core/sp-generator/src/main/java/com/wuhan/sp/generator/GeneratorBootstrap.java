package com.wuhan.sp.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@SpringBootApplication
@MapperScan("com.wuhan.sp.generator.mapper")
public class GeneratorBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorBootstrap.class, args);
    }
}
