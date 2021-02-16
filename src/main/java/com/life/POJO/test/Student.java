package com.life.POJO.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/*
 *@Author life-0
 *@ClassName Student
 *@Date 2020/9/23 14:55
 *@Description: 
 TODO           
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias ("student")
public class Student {
    private String ID;  //学号
    private char Sex;   //性别
    private String Name;    //真实姓名
    private String Email;   //邮箱地址
    private String Icon;    //图标
    private String NickName;    //昵称
    private String Password;    //密码
    private String Account;     //账户
    private String Number;      //编号(一般不使用)
    private String Role;
    
}
