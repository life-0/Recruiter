package com.life.Utils;

import java.util.UUID;

/*
 *@Author life-0
 *@ClassName NumberUtil
 *@Date 2020/9/23 15:37
 *@Description: 
 TODO           
*/
public class NumberUtil {
    //生成随机number 并将其中的-去掉
    public  String getRandomNumber() {
        return UUID.randomUUID ().toString ().replaceAll ("-", "");
    }
}
