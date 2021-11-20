package com.life.Service.user;

import com.life.POJO.user.UserRank;
public interface UserRankService{


    int deleteByPrimaryKey(String number);

    int insert(UserRank record);

    int insertSelective(UserRank record);

    UserRank selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserRank record);

    int updateByPrimaryKey(UserRank record);

}
