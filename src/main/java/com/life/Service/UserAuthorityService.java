package com.life.Service;

import com.life.POJO.UserAuthority;
import org.apache.ibatis.annotations.Param;

public interface UserAuthorityService{

    int deleteByPrimaryKey(@Param("token") String token, @Param("id") String id);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);

    UserAuthority selectByPrimaryKey(@Param("token") String token, @Param("id") String id);

    int updateByPrimaryKeySelective(UserAuthority record);

    int updateByPrimaryKey(UserAuthority record);

}
