package com.life.Mapper;

import com.life.POJO.UserRole;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(String number);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRole> selectAllByUserId(@Param("userId") Integer userId);
}