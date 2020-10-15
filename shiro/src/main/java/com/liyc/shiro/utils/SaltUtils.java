package com.liyc.shiro.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;

public class SaltUtils {

    /**
     * 生成salt的静态方法
     * @param n
     * @return
     */
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String salt = getSalt(8);
        System.out.println(salt);
        System.out.println(new Md5Hash("Action=getBaoJianInfoByBDGuidBDGuid=04fe94a1-9b80-4aac-8e38-ec45b800fd47YS6E05D968-66C6-4F8B-9433-6EB2BE056125"));
        String a = "abcd";
        System.out.println(a.substring(a.length()-1));
    }
}
