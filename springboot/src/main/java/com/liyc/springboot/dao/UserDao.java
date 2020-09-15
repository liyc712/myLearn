package com.liyc.springboot.dao;

import com.liyc.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lyc
 * @Date 2020-9-14 17:34
 * @ClassName UserDao
 * @Description
 */
public interface UserDao extends JpaRepository<User, Long> {

}
