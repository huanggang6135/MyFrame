package org.hg.shiro.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @Author hg
 * @Date 2019/3/26 11:36
 * @Version 1.0
 **/
@Slf4j
public class Encript {
    public static String md5(String str) {
        if (str != null) {
            try {
                //创建具有指定算法名称的信息摘要
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md5.digest(str.getBytes());
                //将得到的字节数组变成字符串返回
                return new String(results);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
