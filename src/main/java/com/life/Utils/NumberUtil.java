package com.life.Utils;

import java.util.UUID;

/*
 *@Author life-0
 *@ClassName NumberUtil
 *@Date 2020/9/23 15:37
 *@Description: 
 TODO          创建UUID: 唯一标识
*/
public class NumberUtil {
    //生成随机number 并将其中的-去掉
    public static String getRandomNumber() {
        return UUID.randomUUID ().toString ().replaceAll ("-", "");
    }
}
