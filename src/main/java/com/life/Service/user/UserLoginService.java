package com.life.Service.user;

import com.life.POJO.user.UserLogin;
public interface UserLoginService{


    int deleteByPrimaryKey(String number);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

}
