package com.liyc.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liyc.springboot.dao.MpUserMapper;
import com.liyc.springboot.model.MpUser;
import com.liyc.springboot.service.MpUserService;
import org.springframework.stereotype.Service;

/**
 * @Author lyc
 * @Date 2020-9-16 15:34
 * @ClassName MpUserServiceImpl
 * @Description TODO
 */

@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements MpUserService {
}
