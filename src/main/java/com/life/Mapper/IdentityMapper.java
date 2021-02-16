package com.life.Mapper;

import com.life.POJO.Identity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IdentityMapper {
    int deleteByPrimaryKey(String number);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);
}