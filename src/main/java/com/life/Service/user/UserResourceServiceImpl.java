package com.life.Service.user;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.Mapper.UserResourceMapper;
import com.life.POJO.user.UserResource;

@Service
public class UserResourceServiceImpl implements UserResourceService{

    @Resource
    private UserResourceMapper userResourceMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return userResourceMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int insert(UserResource record) {
        return userResourceMapper.insert(record);
    }

    @Override
    public int insertSelective(UserResource record) {
        return userResourceMapper.insertSelective(record);
    }

    @Override
    public UserResource selectByPrimaryKey(String number) {
        return userResourceMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateByPrimaryKeySelective(UserResource record) {
        return userResourceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserResource record) {
        return userResourceMapper.updateByPrimaryKey(record);
    }

}
