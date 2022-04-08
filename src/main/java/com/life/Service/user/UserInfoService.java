package com.life.Service.user;


import com.life.POJO.user.UserInfo;

import java.util.ArrayList;
import java.util.List;

public interface UserInfoService {

    int deleteByPrimaryKey(String number);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    int deleteById(ArrayList<Integer> list);

    int updateByPrimaryKeySelective(UserInfo record);


    int updateByPrimaryKey(UserInfo record);

    UserInfo selectById(String id);

    List<UserInfo> queryAll();

}