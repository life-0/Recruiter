package com.life.Service.user;

import com.life.POJO.user.UserInfo;
public interface UserInfoService{


    int deleteByPrimaryKey(String number);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

}
