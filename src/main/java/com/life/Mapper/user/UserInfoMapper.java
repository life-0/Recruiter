package com.life.Mapper.user;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.life.POJO.user.UserInfo;

import org.apache.ibatis.annotations.Mapper;


import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    List<UserInfo> getUserAvatarById(List<Integer> ids);
//    List<UserInfo> queryBySelective(UserInfo userInfo);
}