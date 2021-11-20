package com.life.Service.user;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.POJO.user.UserLogin;
import com.life.Mapper.UserLoginMapper;

@Service
public class UserLoginServiceImpl implements UserLoginService{

    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return userLoginMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int insert(UserLogin record) {
        return userLoginMapper.insert(record);
    }

    @Override
    public int insertSelective(UserLogin record) {
        return userLoginMapper.insertSelective(record);
    }

    @Override
    public UserLogin selectByPrimaryKey(String number) {
        return userLoginMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateByPrimaryKeySelective(UserLogin record) {
        return userLoginMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserLogin record) {
        return userLoginMapper.updateByPrimaryKey(record);
    }

}
