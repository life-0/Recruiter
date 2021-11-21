package com.life.Service.user;

import com.life.Mapper.user.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserInfo;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return userInfoMapper.deleteByPrimaryKey (number);
    }

    @Override
    public int deleteById(int id) {
        return userInfoMapper.deleteById (id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert (record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective (record);
    }

    @Override
    public UserInfo selectById(int id) {
        return null;
    }

    @Override
    public List<UserInfo> showAll() {
        return userInfoMapper.showAll ();
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective (record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey (record);
    }

}
