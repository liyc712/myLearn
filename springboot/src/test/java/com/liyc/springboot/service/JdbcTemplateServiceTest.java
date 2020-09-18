package com.liyc.springboot.service;

import com.liyc.springboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author lyc
 * @Date 2020-9-18 9:24
 * @ClassName JdbcTemplateServiceTest
 * @Description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JdbcTemplateServiceTest {

    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateServiceTest.class);

    @Autowired
    private JdbcTemplateService jdbcTemplateService;

    @Test
    public void saveUser(){
        User user = new User();
        user.setUserName("user_2");
        user.setPassWord("pwd_2");
        //user.setEmail("1232@qq.com");
        user.setNickName("user_2");
        int i = jdbcTemplateService.saveUser(user);
        log.info("saveUser:更新成功【{}】条",i);
    }

    @Test
    public void queryByMap(){
        User user = new User();
        user.setUserName("user_1");
        user.setPassWord("pwd_1");
        //user.setEmail("1232@qq.com");
        user.setNickName("user_1");
        List<User> users = jdbcTemplateService.queryByMap(user);
        log.info("------------------------------------------");
        users.stream().forEach(str -> System.out.println(str));
        log.info("------------------------------------------");
    }

    @Test
    public void queryByarry() {
        User user = new User();
        user.setUserName("user_1");
        user.setPassWord("pwd_1");
        //user.setEmail("1232@qq.com");
        user.setNickName("user_1");
        List<User> users = jdbcTemplateService.queryByarry(user);
        log.info("------------------------------------------");
        users.stream().forEach(str -> System.out.println(str));
        log.info("------------------------------------------");
    }



    @Test
    public void queryForObject() {
        User user = jdbcTemplateService.queryForObject(1L);
        log.info("queryForObject:【{}】",user);
    }

    @Test
    public void batchUpdate() {
        //User user = new User();
        //user.setUserName("user_1");
        //user.setPassWord("pwd_1");
        //user.setEmail("1232@qq.com");
        //user.setNickName("user_1");
        //user.setId(1L);
        //ArrayList<User> users = new ArrayList<>();
        //users.add(user);
        //int[] ints = jdbcTemplateService.batchUpdate(users);

        List<User> users = jdbcTemplateService.queryByarry(null);
        for (User user : users) {
            user.setEmail("email_"+user.getId()+"@qq.com");
            user.setPassWord("pwd_"+user.getId());
            user.setNickName("nick_name_"+user.getId());
            user.setUserName("user_name_"+user.getId());
        }
        int[] ints = jdbcTemplateService.batchUpdate(users);
        log.info("batchUpdate:【{}】", Arrays.toString(ints));
    }

    @Test
    public void batchinsert() {
        ArrayList<User> users = new ArrayList<>(1000);
        for (int i=0;i<1000;i++){
            User user = new User();
            user.setEmail("email_"+i+"@qq.com");
            user.setPassWord("pwd_"+i);
            user.setNickName("nick_name_"+i);
            user.setUserName("user_name_"+i);
            users.add(user);
        }
        int[] batchinsert = jdbcTemplateService.batchinsert(users);
        log.info("batchinsert:【{}】",Arrays.toString(batchinsert));
    }
}