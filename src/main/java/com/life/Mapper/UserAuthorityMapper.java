package com.life.Mapper;

import com.life.POJO.RoleAuthority;
import com.life.POJO.UserAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAuthorityMapper {
    int deleteByPrimaryKey(@Param("token") String token, @Param("id") String id);

    int insert(UserAuthority record);

    int insertSelective(UserAuthority record);

    UserAuthority selectByPrimaryKey(@Param("token") String token, @Param("id") String id);

    int updateByPrimaryKeySelective(UserAuthority record);

    int updateByPrimaryKey(UserAuthority record);

}