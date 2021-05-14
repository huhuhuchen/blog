package com.wbu.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 不积小流无以成江海 不积跬步无以至千里
 * 多学一点知识 少写一行代码
 *
 * @Author 秃头宝贝 2021/3/27 22:21
 */
public class MD5Utils {

    /**
     * 对指定字符串md5加密
     * @param str
     * @return
     */
    public static String md5(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest = md5.digest(str.getBytes());
            String s = new BigInteger(1, digest).toString(16);
            for(int i = 0;i<32-s.length();i++){
                s = "0" + s;
            }
            return s.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用uuid作为随机盐
     * @return
     */
    public static String randomSalt(){
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
    }
}
