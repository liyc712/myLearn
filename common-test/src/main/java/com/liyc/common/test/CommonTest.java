package com.liyc.common.test;

import com.liyc.common.test.rpc.service.AobingService;
import com.liyc.common.test.rpc.service.impl.AobingServiceImpl;
import sun.security.provider.MD5;

import java.lang.reflect.Method;

public class CommonTest {

    public static void main(String[] args) {
        // 反射永福
        AobingService aobingService = new AobingServiceImpl();
        Class<AobingService> serviceClass = AobingService.class;
        try {
            Method method = serviceClass.getMethod("hello", String.class);
            Object tom = method.invoke(aobingService, "tom");
            System.out.println(tom);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
