package com.life.Service.user;

import com.life.POJO.user.UserLogin;
import org.apache.ibatis.annotations.Param;

public interface UserLoginService {


    int deleteByPrimaryKey(String number);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(String number);

    UserLogin selectById(Integer id);

    int updateByID(UserLogin record);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

}
