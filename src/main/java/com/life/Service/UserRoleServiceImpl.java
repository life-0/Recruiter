package com.life.Service;

import com.life.POJO.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.Mapper.UserRoleMapper;
import com.life.POJO.UserRole;
import com.life.Service.UserRoleService;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public int deleteByPrimaryKey(String role, String id) {
        return userRoleMapper.deleteByPrimaryKey (role, id);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert (record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective (record);
    }

    @Override
    public UserRole selectByPrimaryKey(String role, String id) {
        return userRoleMapper.selectByPrimaryKey (role, id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective (record);
    }

    @Override
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey (record);
    }

    @Override
    public List<User> selectByName(String name) {
        return userRoleMapper.selectByName (name);
    }

}
