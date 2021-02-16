package com.life.Mapper;

import com.life.POJO.RoleAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleAuthorityMapper {
    int deleteByPrimaryKey(@Param("token") String token, @Param("id") String id);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    RoleAuthority selectByPrimaryKey(@Param("token") String token, @Param("id") String id);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);
}