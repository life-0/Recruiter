package com.life.Service;

import com.life.POJO.UserAuthority;
public interface UserAuthorityService{


    int deleteByPrimaryKey(String token,String id);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);

    UserAuthority selectByPrimaryKey(String token,String id);

    int updateByPrimaryKeySelective(UserAuthority record);

    int updateByPrimaryKey(UserAuthority record);

}
