package com.life.POJO.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/*
 *@Author life-0
 *@ClassName Admin
 *@Date 2020/10/5 11:52
 *@Description: 
 TODO           
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias ("admin")

public class Admin {
    private int ID;
    private String Account;
    private String Password;
    private String Name;
    private String Email;
    private String Number;
    private String Role;


}
