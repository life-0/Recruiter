package com.life.Service;

import com.life.POJO.UserRole;
public interface UserRoleService{


    int deleteByPrimaryKey(String role,String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String role,String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

}
