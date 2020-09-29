package com.liyc.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Test
    public void testWrapper() {
        Heros heros = new Heros();
        heros.setName("张飞");
        QueryWrapper wrapper = new QueryWrapper(heros);
        // 此处需写sql中的列名,不能写javaBean属性名
        wrapper.select("id","name", "hp_5s_max");
        Page page = iHerosService.page(new Page(1,10), wrapper);
        System.out.println(page.getTotal());
    }


}