package com.life.Service;

import com.life.POJO.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
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
