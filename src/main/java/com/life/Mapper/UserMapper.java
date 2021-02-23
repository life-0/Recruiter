package com.life.Mapper;

import com.life.POJO.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("number") String number);

    int insert(User record);

    int insertSelective(User record);

    User queryUserByID(@Param("id") int id);

    User selectByPrimaryKey(@Param("id") Integer id, @Param("number") String number);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByName(String name);

    List<User> showAll();
}