package com.life.Mapper.user;

import com.life.POJO.user.UserRank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRankMapper {
    int deleteByPrimaryKey(String number);

    int insert(UserRank record);

    int insertSelective(UserRank record);

    UserRank selectByPrimaryKey(String number);

    UserRank selectById(Integer id);    //通过id查找

    int updateByPrimaryKeySelective(UserRank record);

    int updateByPrimaryKey(UserRank record);


}