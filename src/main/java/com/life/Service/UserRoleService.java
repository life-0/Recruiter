package com.life.Service;

import java.util.List;
import com.life.POJO.UserRole;
public interface UserRoleService{


    int deleteByPrimaryKey(String number);

    int deleteByUser_ID(Integer UserID);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRole> selectAllByUserId(Integer userId);

}
