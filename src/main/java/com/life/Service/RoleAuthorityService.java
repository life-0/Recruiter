package com.life.Service;

import com.life.POJO.RoleAuthority;
public interface RoleAuthorityService{


    int deleteByPrimaryKey(String token,String id);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    RoleAuthority selectByPrimaryKey(String token,String id);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);

}
