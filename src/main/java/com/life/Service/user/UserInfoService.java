package com.life.Service.user;

import com.life.POJO.user.UserInfo;

import java.util.List;

public interface UserInfoService {

    int deleteByPrimaryKey(String number);

    int deleteById(int id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectById(int id);

    List<UserInfo> showAll();

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

}
