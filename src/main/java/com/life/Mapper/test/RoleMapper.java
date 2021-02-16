package com.life.Mapper.test;

import com.life.POJO.test.Role;
import com.life.POJO.test.RoleList;

import java.util.List;

/*
 *@Author life-0
 *@ClassName RoleMapper
 *@Date 2020/11/3 8:52
 *@Description: 
 TODO           只对角色进行操作
*/
public interface RoleMapper {
    int queryCount_Role(int id);  //查询某个用户在表中的权限数 (一般情况下,不能超过权限表的行数)
    void addRole(int id ,String Authority); //增加角色

    void delRole(int id); //删除角色

    void updRole(Role role ,String Authority); //更新角色名字

    List<RoleList> queryRole(int id); //查询角色名字

    List<RoleList> getAllRole();    //获取所有的角色的名字

}
