package com.liyc.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.liyc.common.util.common.ResponseData;
import com.liyc.springboot.model.MpUser;
import com.liyc.springboot.service.MpUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lyc
 * @Date 2020-11-18 18:19
 * @ClassName SpringCacheTest
 * @Description
 */
@RestController
@RequestMapping("/cache")
public class SpringCacheTest {

    private static final Logger log = LoggerFactory.getLogger(SpringCacheTest.class);

    @Autowired
    private MpUserService mpUserService;

    @PostMapping("/testCache/{id}")
    @Cacheable(cacheNames = "cache_user", key="'user_' + #id")
    public ResponseData testCache( @PathVariable("id")Long id) {
        MpUser mpUser = mpUserService.getById(id);
        log.info("testCache:{}", JSONObject.toJSONString(mpUser));
        return ResponseData.createBySuccess(mpUser);
    }

    @PostMapping("/testCache2")
    @Cacheable(cacheNames = "cache_user", key="'user_' + #user.id")
    public ResponseData testCache2(@RequestBody MpUser user) {
        MpUser mpUser = mpUserService.getById(user.getId());
        log.info("testCache:{}", JSONObject.toJSONString(mpUser));
        return ResponseData.createBySuccess(mpUser);
    }
}
