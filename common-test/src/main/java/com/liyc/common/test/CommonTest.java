package com.liyc.common.test;

import com.liyc.common.test.rpc.service.AobingService;
import com.liyc.common.test.rpc.service.impl.AobingServiceImpl;
import org.junit.Test;
import sun.security.provider.MD5;

import java.lang.reflect.Method;
import java.util.Objects;

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

    @Test
    public void test() {
        Integer i = null;
        System.out.println(Objects.equals(1,i));
    }
}
