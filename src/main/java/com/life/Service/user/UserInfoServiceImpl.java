package com.life.Service.user;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.POJO.user.UserInfo;
import com.life.Mapper.UserInfoMapper;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return userInfoMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(String number) {
        return userInfoMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

}
