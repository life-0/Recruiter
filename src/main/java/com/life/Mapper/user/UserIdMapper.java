package com.life.Mapper.user;

import com.life.POJO.user.UserId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserIdMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("number") String number);

    int insert(UserId record);

    int insertSelective(UserId record);

    UserId selectById(@Param("id") Integer id, @Param("number") String number);

}