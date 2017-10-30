package com.ucsmy.commons.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by 钟廷员 on 2016/12/9.
 */
public class StringUtils extends org.springframework.util.StringUtils {
    private final static String charlist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static Number formatNumber(Object obj) {
        if(obj == null)
            return null;
        if(obj instanceof Number) {
            return (Number)obj;
        }
        if(!(obj instanceof String)) {
            return null;
        }
        String s = (String)obj;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
        }
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
        }
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
        }
        return null;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String firstLetterUpperCase(String name) {
        char[] cs= name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * 首字母小写
     * @param name
     * @return
     */
    public static String firstLetterLowerCase(String name) {
        char[] cs= name.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }

    /**
     * 获取 lenght位数的随机数值和大小写字母组合字符串
     * @param length 随机位数
     * @return
     */
    public static String getRandom(int length){
        Random random = new Random();
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < length; i++){
            str.append(charlist.charAt(random.nextInt(charlist.length())));
        }
        return str.toString();
    }

    /**
     * 密码加密
     * @param userName 用户名
     * @param password 密码
     * @param salt 盐
     * @return MD5加密字符串
     */
    public static String passwordEncrypt(String userName, String password, String salt) {
        return EncryptUtils.MD5(EncryptUtils.SHA256(EncryptUtils.SHA512(userName.concat(password).concat(salt))));
    }

    public static void main(String[] args) {
        System.out.println(passwordEncrypt("admin", "123456", "geHDS"));
    }
}
