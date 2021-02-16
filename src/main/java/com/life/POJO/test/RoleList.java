package com.life.POJO.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/*
 *@Author life-0
 *@ClassName RoleList
 *@Date 2020/11/13 20:16
 *@Description: 
 TODO           //用户权限表
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias ("PermissionList")
public class RoleList {
    private int ID;
    private String Name;
}
