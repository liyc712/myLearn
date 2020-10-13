package com.liyc.common.test.rpc.service.impl;

import com.liyc.common.test.rpc.service.AobingService;

/**
 * @Author lyc
 * @Date 2020-10-12 10:47
 * @ClassName AobingServiceImpl
 * @Description TODO
 */
public class AobingServiceImpl implements AobingService {
    @Override
    public String hello(String name) {
        return "Yo man Hello，I am" + name;
    }
}
