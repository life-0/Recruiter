package com.life.Service.user;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.POJO.user.UserId;
import com.life.Mapper.UserIdMapper;

@Service
public class UserIdServiceImpl implements UserIdService{

    @Resource
    private UserIdMapper userIdMapper;

    @Override
    public int deleteByPrimaryKey(Integer id,String number) {
        return userIdMapper.deleteByPrimaryKey(id,number);
    }

    @Override
    public int insert(UserId record) {
        return userIdMapper.insert(record);
    }

    @Override
    public int insertSelective(UserId record) {
        return userIdMapper.insertSelective(record);
    }

}
