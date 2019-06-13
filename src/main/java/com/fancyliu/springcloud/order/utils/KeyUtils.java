package com.fancyliu.springcloud.order.utils;

import java.util.Random;

/**
 * 类描述:
 * 简单的主键生成器,线上分布式环境考虑引入 Snowflake
 *
 * @author : Liu Fan
 * @date : 2019-06-11 13:20
 */
public class KeyUtils {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
