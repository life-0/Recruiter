package com.life.Service;

import com.life.POJO.RoleAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAuthorityService{
    int deleteByPrimaryKey(@Param("token") String token, @Param("id") String id);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    RoleAuthority selectByPrimaryKey(@Param("token") String token, @Param("id") String id);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);

    List<RoleAuthority> selectByName(String name);

}
