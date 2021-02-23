package com.life.Service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.User;
import com.life.Mapper.UserMapper;
import com.life.Service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id, String number) {
        return userMapper.deleteByPrimaryKey (id, number);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert (record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective (record);
    }

    @Override
    public User queryUserByID(int id) {
        return userMapper.queryUserByID (id);
    }

    @Override
    public User selectByPrimaryKey(Integer id, String number) {
        return userMapper.selectByPrimaryKey (id, number);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective (record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey (record);
    }

    @Override
    public List<User> selectByName(String name) {
        return userMapper.selectByName (name);
    }

    @Override
    public List<User> showAll() {
        return userMapper.showAll ();
    }

}
