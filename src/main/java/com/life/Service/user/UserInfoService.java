package com.life.Service.user;

import com.life.POJO.user.UserInfo;

import java.util.ArrayList;
import java.util.List;

public interface UserInfoService {

    int deleteByPrimaryKey(String number);

    int deleteById(ArrayList<Integer> list);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectById(int id);

    List<UserInfo> showAll();

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

}
