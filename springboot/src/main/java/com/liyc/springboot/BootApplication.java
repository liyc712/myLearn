package com.liyc.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger("BootApplication");
//    private String str = "str";

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
        log.info("-------------BootApplication started-------------------------------");
    }
}
