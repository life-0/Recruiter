package com.life.Service;

import com.life.POJO.Identity;

import java.util.List;

public interface IdentityService{

    int deleteByPrimaryKey(String number);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);

    List<Identity> selectByName(String name);

}
