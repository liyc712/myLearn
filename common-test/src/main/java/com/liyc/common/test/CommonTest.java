package com.liyc.common.test;

import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.liyc.common.test.rpc.service.AobingService;
import com.liyc.common.test.rpc.service.impl.AobingServiceImpl;
import sun.java2d.pipe.SpanIterator;
import sun.security.provider.MD5;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class CommonTest {

    public static void main(String[] args) throws Exception{

        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("code", new Callable<String>() {
            public String call() {
                String strProValue="begin "+"code"+"!";
                return strProValue;
            }
        });
        System.out.println("value : " + resultVal); //value : begin code!

        List<String> list = new ArrayList<String>();
        list.add("aa") ;
        list.add("bb");
        list.add("cc");
        List<List<String>> lists = Lists.partition(list, 2);
        System.out.println(lists);
    }

    /**
     * 反射
     */
    public static void test1() {
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
