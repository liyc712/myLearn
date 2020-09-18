package com.liyc.springboot.service.impl;

import com.liyc.springboot.dao.JdbcTemplateDao;
import com.liyc.springboot.model.User;
import com.liyc.springboot.service.JdbcTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lyc
 * @Date 2020-9-18 9:03
 * @ClassName JdbcTemplateServiceImpl
 * @Description JdbcTemplate
 */
@Service
@Transactional
public class JdbcTemplateServiceImpl implements JdbcTemplateService {

    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateServiceImpl.class);

    @Autowired
    private JdbcTemplateDao jdbcTemplateDao;


    @Override
    public int saveUser(User user) {
        return jdbcTemplateDao.saveUser(user);
    }

    @Override
    public List<User> queryByMap(User user) {
        return jdbcTemplateDao.queryByMap(user);
    }

    @Override
    public List<User> queryByarry(User user) {
        return jdbcTemplateDao.queryByarry(user);
    }

    @Override
    public User queryForObject(Long id) {
        return jdbcTemplateDao.queryForObject(id);
    }

    @Override
    public int[] batchUpdate(List<User> users) {
        return jdbcTemplateDao.batchUpdate(users);
    }

    @Override
    public int[] batchinsert(List<User> users) {
        return jdbcTemplateDao.batchinsert(users);
    }
}
