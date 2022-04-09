package com.life.Service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.life.Mapper.user.UserInfoMapper;
import com.life.POJO.user.UserLogin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> queryBySelective(UserInfo record) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<> (record);
        List<UserInfo> userInfos = userInfoMapper.selectList (wrapper);
        for (UserInfo info : userInfos) {
            System.out.println (info.toString ());
        }
        return userInfos;
    }

    @Override
    public List<UserInfo> queryAll() {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<> ();
        return userInfoMapper.selectList (wrapper);
    }


}

