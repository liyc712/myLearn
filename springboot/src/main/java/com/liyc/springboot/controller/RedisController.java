package com.liyc.springboot.controller;

import com.liyc.common.util.common.ResponseData;
import com.liyc.springboot.component.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lyc
 * @Date 2020-9-14 18:36
 * @ClassName RedisController
 * @Description Redis
 */
@RestController
public class RedisController {

    private static final Logger log = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    //@Autowired
    //private UserDao userDao;

    /**
     * 使用Cacheable注解实现缓存
     * @param id
     * @return
     */
    @GetMapping("/getUser/{id}")
    @Cacheable(value="user-key")// 使用spring缓存
    public ResponseData getUser(@PathVariable("id") Long id) {
        //User user = userDao.findById(id).get();
        return ResponseData.createBySuccess();
    }

    /**
     * 手动放入缓存并取出
     * @param id
     * @return
     */
    @GetMapping("/queryUser/{id}")
    public ResponseData queryUser(@PathVariable("id") Long id) {
       /* User user = (User)redisUtils.get("user-key:"+id);
        if(user != null){
            log.info("从缓存中取出:【{}】",user.toString());
        }else{
            user = userDao.findById(id).get();
            redisUtils.set("user-key:" + id, user,60);
        }*/
        return ResponseData.createBySuccess();
    }
}
