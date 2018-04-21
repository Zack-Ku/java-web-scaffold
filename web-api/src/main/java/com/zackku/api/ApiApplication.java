package com.zackku.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Zack
 * @date 2018/4/21
 */
@ComponentScan(basePackages = {"com.zackku"})
@MapperScan("com.zackku")
@EnableAutoConfiguration
public class ApiApplication extends SpringBootServletInitializer {
    public static void main(String args[]) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
