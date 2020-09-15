package com.liyc.springboot.controller;

import com.liyc.common.util.common.ResponseData;
import com.liyc.springboot.dao.UserDao;
import com.liyc.springboot.model.User;
import com.liyc.springboot.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @Author lyc
 * @Date 2020-9-1 15:51
 * @ClassName TestController
 * @Description TODO
 */
@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserDao userDao;

    //@PostMapping
    //public ResponseData test01(@RequestBody TestVo vo){
    //
    //    return ResponseData.createBySuccess();
    //}
    @PostMapping("/addUser")
    public ResponseData addUser() {
        User user = new User();
        user.setCreateTime(System.currentTimeMillis());
        user.setUserName("user_1");
        user.setNickName("user_1");
        user.setEmail("12323@qq.com");
        user.setPassWord("123456");
        User u = userDao.save(user);
        return ResponseData.createBySuccess(u);
    }

}
