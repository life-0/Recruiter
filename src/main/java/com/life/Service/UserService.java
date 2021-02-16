package com.life.Service;

import com.life.POJO.User;
import org.apache.ibatis.annotations.Param;

public interface UserService{


    int deleteByPrimaryKey(Integer id,String number);

    int insert(User record);

    int insertSelective(User record);

    User queryUser(@Param("id") int id);

    User selectByPrimaryKey(Integer id,String number);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
