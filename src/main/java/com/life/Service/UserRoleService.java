package com.life.Service;

import com.life.POJO.User;
import com.life.POJO.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleService{
    int deleteByPrimaryKey(@Param("role") String role, @Param("id") String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(@Param("role") String role, @Param("id") String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<User> selectByName(String name);

}
