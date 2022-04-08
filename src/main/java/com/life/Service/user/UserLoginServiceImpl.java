package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.life.Mapper.user.UserLoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserLogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {

    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public List<UserLogin> queryAll() {

        return userLoginMapper.selectList (new QueryWrapper<> ());
    }

    public UserLogin querySelective(UserLogin userLogin) {
        QueryWrapper<UserLogin> wrapper = new QueryWrapper<> (userLogin);
        return userLoginMapper.selectOne (wrapper);
    }
}
