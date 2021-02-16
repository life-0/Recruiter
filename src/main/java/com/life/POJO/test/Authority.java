package com.life.POJO.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/*
 *@Author life-0
 *@ClassName Authority
 *@Date 2020/11/13 20:16
 *@Description: 
 TODO           
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Alias ("authority")
public class Authority {
    String name;
    String token;
}
