package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.life.Mapper.user.UserRankMapper;
import com.life.POJO.user.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserRank;

import java.util.List;

@Service
public class UserRankServiceImpl extends ServiceImpl<UserRankMapper, UserRank> implements UserRankService {

    @Resource
    private UserRankMapper userRankMapper;


    public List<UserRank> queryBySelective(UserRank record) {
        QueryWrapper<UserRank> wrapper = new QueryWrapper<> (record);
        return userRankMapper.selectList (wrapper);
    }

    public UserRank queryById(Integer id) {
        return userRankMapper.selectById (id);
    }

    public List<UserRank> queryAll() {
        QueryWrapper<UserRank> wrapper = new QueryWrapper<> ();
        return userRankMapper.selectList (wrapper);
    }

    public Boolean updateUserRank(UserRank userRank) {
        UpdateWrapper<UserRank> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("id", userRank.getId ());
        int result = userRankMapper.update (userRank, wrapper);
        return result > 0;
    }

    public Boolean addUserRank(UserRank userRank) {
        int result = userRankMapper.insert (userRank);
        return result > 0;
    }

    public Boolean delUserRank(List<Integer> idList) {
        int result = userRankMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
