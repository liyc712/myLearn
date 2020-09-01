package com.liyc.springboot.controller;

import com.liyc.common.util.common.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lyc
 * @Date 2020-9-1 15:51
 * @ClassName TestController
 * @Description TODO
 */
@RestController("/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @PostMapping
    public ResponseData test01(){

        log.info("-------------test01--------------------");

        return ResponseData.createBySuccess();
    }
}
