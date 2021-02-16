package com.life.POJO.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

/*
 *@Author life-0
 *@ClassName Role
 *@Date 2020/11/10 20:33
 *@Description: 
 TODO           角色
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias ("role")
public class Role {
    private int ID;
    private String Name;
    private List<String> authority;
}
