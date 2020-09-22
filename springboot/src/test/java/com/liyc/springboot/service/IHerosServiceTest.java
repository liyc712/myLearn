package com.liyc.springboot.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liyc.springboot.model.Heros;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author lyc
 * @Date 2020-9-22 15:45
 * @ClassName IHerosServiceTest
 * @Description mybaitis-plus使用
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IHerosServiceTest {

    private static final Logger log = LoggerFactory.getLogger(IHerosServiceTest.class);

    @Autowired
    private IHerosService iHerosService;

    @Test
    public void getById() {
        Heros heros = iHerosService.getById(10000L);
        log.info("getById:【{}】",heros);
    }


}