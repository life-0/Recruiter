package com.life.Service.user;

import com.life.POJO.user.UserResource;
public interface UserResourceService{

    int deleteByPrimaryKey(String number);

    int insert(UserResource record);

    int insertSelective(UserResource record);

    UserResource selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserResource record);

    int updateByPrimaryKey(UserResource record);

}
