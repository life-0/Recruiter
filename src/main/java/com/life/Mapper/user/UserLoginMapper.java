package com.life.Mapper.user;

import com.life.POJO.user.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginMapper {
    int deleteByPrimaryKey(String number);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(String number);

    UserLogin selectById(Integer id);

    UserLogin selectByAccount(@Param("acc") String account, @Param("pwd") String password);

    int updateByID(UserLogin record);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}