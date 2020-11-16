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
import java.util.Map;

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

    @Override
    public List<Map<String, Object>> queryList() {
        return jdbcTemplateDao.queryList();
    }

    @Override
    public int updateUserNameById(Long id, String userName) {
        return jdbcTemplateDao.updateUserNameById(id,userName);
    }


    private int updateUser1(User user) {
        return updateUserNameById(user.getId(), user.getUserName());
    }
    /**
     * 事务回滚测试
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        int i = updateUser1(user);
        log.info("执行结果:【{}】",i);
        if (i > 0) {
            log.info("抛出运行是异常");
            throw new RuntimeException();
        }

        return i;
    }
}
