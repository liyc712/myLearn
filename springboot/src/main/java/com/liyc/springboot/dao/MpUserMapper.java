package com.liyc.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liyc.springboot.model.MpUser;
import org.springframework.stereotype.Repository;

/**
 * @Author lyc
 * @Date 2020-9-16 15:32
 * @ClassName MpUserMapper
 * @Description TODO
 */
@Repository
public interface MpUserMapper extends BaseMapper<MpUser> {
}
