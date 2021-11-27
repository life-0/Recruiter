package com.life.Service.user;

import com.life.Mapper.user.UserIdMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserId;

@Service
public class UserIdServiceImpl implements UserIdService {

    @Resource
    private UserIdMapper userIdMapper;

    @Override
    public int deleteByPrimaryKey(Integer id, String number) {
        return userIdMapper.deleteByPrimaryKey (id, number);
    }

    @Override
    public int insert(UserId record) {
        return userIdMapper.insert (record);
    }

    @Override
    public int insertSelective(UserId record) {
        return userIdMapper.insertSelective (record);
    }

    @Override
    public UserId selectById(Integer id, String number) {
        return userIdMapper.selectById (id, number);
    }

    @Override
    public Integer maxID() {
        return userIdMapper.maxID ();
    }

    @Override
    public int resetAutoIncrementID(Integer id) {   //使用直接调用maxID方法
        return userIdMapper.resetAutoIncrementID (maxID ());
    }

}
