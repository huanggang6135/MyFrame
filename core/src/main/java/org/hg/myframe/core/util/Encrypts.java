package  org.hg.myframe.core.util;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @Author hg
 * @Date 2019/3/26 11:36
 * @Desc
 * @Version 1.0
 **/
public class Encrypts {
    private static final Random RANDOM = new Random();

    public static String md5(String str) {
        if (str != null) {
            try {
                //创建具有指定算法名称的信息摘要
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md5.digest(str.getBytes(UTF_8));
                //将得到的字节数组变成字符串返回
                return new String(results, UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int randInt() {
        return RANDOM.nextInt();
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String passwordMd5(String s, int salt) {
        return md5(s + salt);
    }
}
