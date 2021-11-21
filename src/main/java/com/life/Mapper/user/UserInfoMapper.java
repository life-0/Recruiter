package com.life.Mapper.user;

import com.life.POJO.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(String number);

    int deleteById(int id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectById(int id);

    List<UserInfo> showAll();

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

}