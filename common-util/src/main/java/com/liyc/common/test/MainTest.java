package com.liyc.common.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * @Author lyc
 * @Date 2020-8-24 10:30
 * @ClassName MainTest
 * @Description
 */
public class MainTest {

    public static void main(String[] args) {
        Long startTime = 1592982000000L;
        Long endTime = 1594798200000L;
        long l = (endTime - startTime)/1000/60;
        int i = new BigDecimal((endTime - startTime)).divide((new BigDecimal((1000 * 60 * 60))), BigDecimal.ROUND_UP).intValue();
        String s = new BigDecimal((endTime - startTime)).divide((new BigDecimal((1000 * 60 * 60)))).toString();
        System.out.println(i);
        System.out.println(s);

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list.get(0));
        int a = 0;
    }
}
