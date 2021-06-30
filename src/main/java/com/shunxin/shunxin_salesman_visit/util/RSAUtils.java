package com.shunxin.shunxin_salesman_visit.util;


import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yinyang
 * @version V1.0
 * @ClassName :
 * @Description :
 * @date 2021/6/28
 */
public class RSAUtils {
    /**
     * 密钥长度 于原文长度对应 以及越长速度越慢
     */
    private final static int KEY_SIZE = 1024;
    /**
     * 用于封装随机产生的公钥与私钥
     */
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();


    /**
     * 随机生成密钥对
     * @throws Exception
     */
    public static void genKeyPair() throws Exception {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = encryptBASE64(publicKey.getEncoded());
        // 得到私钥字符串
        String privateKeyString = encryptBASE64(privateKey.getEncoded());
        // 将公钥和私钥保存到Map
        //0表示公钥
        keyMap.put(0, publicKeyString);
        //1表示私钥
        keyMap.put(1, privateKeyString);
    }

    //编码返回字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        //return (new BASE64Encoder()).encodeBuffer(key);
        return Base64.getEncoder().encodeToString(key);
    }

    //解码返回byte
    public static byte[] decryptBASE64(String key) throws Exception {
        //return (new BASE64Decoder()).decodeBuffer(key);
        return Base64.getDecoder().decode(key);
    }


    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = decryptBASE64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = encryptBASE64(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = decryptBASE64(str);
        //base64编码的私钥
        byte[] decoded = decryptBASE64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }


    public static void main(String[] args) throws Exception {
        long temp = System.currentTimeMillis();
        //生成公钥和私钥
        //genKeyPair();
        //加密字符串
        //System.out.println("公钥:" + keyMap.get(0));
        //System.out.println("私钥:" + keyMap.get(1));
        System.out.println("生成密钥消耗时间:" + (System.currentTimeMillis() - temp) / 1000.0 + "秒");
        String gkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQtXoDu1My/HdDACQPcbhCaKJvBUwz4KKnZdLL0AfVEvpKeq+DCdUFjrm6edeI+pcrNRWS5vonGG5BoTP0/oxobmhZq2zmdNnJCGt1GiMmdogmL3NlBaPsBieZ9HHrIATMaQnzutyhTTo5UEumbXyQvjE32UfNoRjeTe8KytnuyQIDAQAB";
        String skey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJC1egO7UzL8d0MAJA9xuEJoom8FTDPgoqdl0svQB9US+kp6r4MJ1QWOubp514j6lys1FZLm+icYbkGhM/T+jGhuaFmrbOZ02ckIa3UaIyZ2iCYvc2UFo+wGJ5n0cesgBMxpCfO63KFNOjlQS6ZtfJC+MTfZR82hGN5N7wrK2e7JAgMBAAECgYAqLHmu9L0+ss2fPT9FMQNed1g/uu+GfwVofAh/VdWyh6Fia3cTXZ4zzHDco/3o8f90nDf5ZE+rbTdU8UJPOJB6urPy/hu0nwXNlFyCed96BUBQfmF2HbIe4oPfDA5K8BJq4lo25Cf7gneUB9XO1CPUwrmDVs/Wy/d+2IDm00rkMQJBAPyt1Dv95FS7192q1N6ir/pa/H59SftLP0hNMbJTGLwstzFupiGB7yva3LJEWACt/Np030Tc27ja7McHPSLK0y8CQQCSnF5FQgtdJjC49WVw7WetoSg1JMumyODKeAHb+HLf1O8I5Tfaq2MgT/6/4xUIkcTbcuw5csA2AMmV655r1D+HAkBDZfaLfgCOnYBJ70xSimCYTfa1oqO+NOcPWQ/deg7J+r9unw4POAJc10cxAcvbeo1MlAoN6z9sgnDP8d1bz3AfAkAgAp4elwXuJ5l5uLKWTm9VnJsvx0Hjv3Y9HqihQ4SpVE+AbLOePc9dzbl8YfNEtLb7hwMGpARNhix9XD1xo5zfAkBwjOd11/Jh/1NcWj7+qlGUly+K16vRCJc0aAJYhH6nS2GwhUNJsTZsTmQ6TasljNNu0QlQGZRqbY4lMh/G80do";


        String message = "RSA测试aaa";
        System.out.println("原文:" + message);

        temp = System.currentTimeMillis();
        String messageEn = encrypt(message, gkey);
        System.out.println("密文:" + messageEn);
        System.out.println("加密消耗时间:" + (System.currentTimeMillis() - temp) / 1000.0 + "秒");

        temp = System.currentTimeMillis();

        String messageDe = decrypt(messageEn, skey);
        System.out.println("解密:" + messageDe);
        System.out.println("解密消耗时间:" + (System.currentTimeMillis() - temp) / 1000.0 + "秒");
    }



}
