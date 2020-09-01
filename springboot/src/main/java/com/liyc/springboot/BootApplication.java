package com.liyc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author lyc
 * @Date 2020-9-1 15:37
 * @ClassName BootApplication
 * @Description 入口
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
