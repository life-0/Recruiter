package com.life.Mapper.user;

import com.life.POJO.user.UserResource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserResourceMapper {
    int deleteByPrimaryKey(String number);

    int insert(UserResource record);

    int insertSelective(UserResource record);

    UserResource selectByPrimaryKey(String number);

    UserResource selectById(int id);

    int updateByPrimaryKeySelective(UserResource record);

    int updateByPrimaryKey(UserResource record);
}