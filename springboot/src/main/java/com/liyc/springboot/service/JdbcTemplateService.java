package com.liyc.springboot.service;

import com.liyc.springboot.model.User;

import java.util.List;
import java.util.Map;

/**
 * @Author lyc
 * @Date 2020-9-17 17:37
 * @ClassName JdbcTemplateService
 * @Description TODO
 */
public interface JdbcTemplateService {

    int saveUser(User user);

    List<User> queryByMap(User user);

    List<User> queryByarry(User user);

    User queryForObject(Long id);

    int[] batchUpdate(List<User> users);

    int[] batchinsert(List<User> users);

    List<Map<String, Object>> queryList();
}
