package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.life.Mapper.user.UserLoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserLogin;

import java.util.List;


@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {

    @Resource
    private UserLoginMapper userLoginMapper;

    public List<UserLogin> queryAll() {
        return userLoginMapper.selectList (new QueryWrapper<> ());
    }

    public UserLogin querySelective(UserLogin userLogin) {
        QueryWrapper<UserLogin> wrapper = new QueryWrapper<> (userLogin);
        return userLoginMapper.selectOne (wrapper);
    }

    public Boolean updateUserLogin(UserLogin userLogin) {
        UpdateWrapper<UserLogin> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("id", userLogin.getId ());
        int result = userLoginMapper.update (userLogin, wrapper);
        return result > 0;
    }

    public Boolean addUserLogin(UserLogin userLogin) {
        int result = userLoginMapper.insert (userLogin);
        return result > 0;
    }

    public Boolean delUserLogin(List<Integer> idList) {
        int result = userLoginMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
