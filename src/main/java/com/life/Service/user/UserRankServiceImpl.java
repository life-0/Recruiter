package com.life.Service.user;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.POJO.user.UserRank;
import com.life.Mapper.UserRankMapper;

@Service
public class UserRankServiceImpl implements UserRankService{

    @Resource
    private UserRankMapper userRankMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return userRankMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int insert(UserRank record) {
        return userRankMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRank record) {
        return userRankMapper.insertSelective(record);
    }

    @Override
    public UserRank selectByPrimaryKey(String number) {
        return userRankMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRank record) {
        return userRankMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRank record) {
        return userRankMapper.updateByPrimaryKey(record);
    }

}
