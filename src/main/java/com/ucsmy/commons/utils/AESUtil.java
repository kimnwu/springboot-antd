package com.ucsmy.commons.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {

    public static final String strKey = "ucasStrkey";

    public static void main(String[] args) {
        // 密钥的种子，可以是任何形式，本质是字节数组
        String strKey = "lttclaw";
        // 密钥数据
        byte[] rawKey = getRawKey(strKey.getBytes());
        // 密码的明文
        String clearPwd = "My world is full of wonders! No body can match my spirit";
        // 密码加密后的密文
        byte[] encryptedByteArr = encrypt(rawKey, clearPwd);
        String encryptedPwd = new String(encryptedByteArr);
        System.out.println(encryptedPwd);
        // 解密后的字符串
        String decryptedPwd = decrypt(encryptedByteArr, rawKey);
        System.out.println(decryptedPwd);

    }

    /**
     * @param rawKey   密钥
     * @param clearPwd 明文字符串
     * @return 密文字节数组
     */
    public static byte[] encrypt(byte[] rawKey, String clearPwd) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(rawKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encypted = cipher.doFinal(clearPwd.getBytes());
            return encypted;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param encrypted 密文字节数组
     * @param rawKey    密钥
     * @return 解密后的字符串
     */
    public static String decrypt(byte[] encrypted, byte[] rawKey) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(rawKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decrypted = cipher.doFinal(encrypted);
            return new String(decrypted);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @param
     * @return 密钥数据
     */
    public static byte[] getRawKey(byte[] seed) {
        byte[] rawKey = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seed);
            // AES加密数据块分组长度必须为128比特，密钥长度可以是128比特、192比特、256比特中的任意一个
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            rawKey = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
        }
        return rawKey;
    }
}