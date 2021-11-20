package com.life.Mapper.user;

import com.life.POJO.user.UserRank;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRankMapper {
    int deleteByPrimaryKey(String number);

    int insert(UserRank record);

    int insertSelective(UserRank record);

    UserRank selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserRank record);

    int updateByPrimaryKey(UserRank record);
}