package com.life.Mapper;

import com.life.POJO.User;
import com.life.POJO.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(@Param("role") String role, @Param("id") String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(@Param("role") String role, @Param("id") String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<User> selectByName(String name);
}