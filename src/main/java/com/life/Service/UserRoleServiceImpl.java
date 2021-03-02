package com.life.Service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.life.Mapper.UserRoleMapper;
import com.life.POJO.UserRole;
import com.life.Service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return userRoleMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    @Override
    public UserRole selectByPrimaryKey(String number) {
        return userRoleMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserRole> selectAllByUserId(Integer userId) {
        return userRoleMapper.selectAllByUserId(userId);
    }

}
