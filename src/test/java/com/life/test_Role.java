package com.life;

import com.life.Utils.NumberUtil;
import org.junit.jupiter.api.Test;

/*
 *@Author life-0
 *@ClassName test_Role
 *@Date 2020/12/25 11:24
 *@Description: 
 TODO           
*/
public class test_Role {
    @Test
    public void queryCount_Role(){
        NumberUtil numberUtil = new NumberUtil ();
        int i=1;
        while (i<10){
            System.out.println (numberUtil.getRandomNumber ());
            i++;
        }
    }
}
