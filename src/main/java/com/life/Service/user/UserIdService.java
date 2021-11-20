package com.life.Service.user;

import com.life.POJO.user.UserId;
public interface UserIdService{


    int deleteByPrimaryKey(Integer id,String number);

    int insert(UserId record);

    int insertSelective(UserId record);

}
