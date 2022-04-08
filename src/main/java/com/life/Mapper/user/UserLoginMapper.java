package com.life.Mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.life.POJO.user.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginMapper extends BaseMapper<UserLogin> {

}