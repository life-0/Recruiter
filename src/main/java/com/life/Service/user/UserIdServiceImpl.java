package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.life.Mapper.user.JobHuntingInfoMapper;
import com.life.Mapper.user.UserIdMapper;
import com.life.POJO.user.JobHuntingInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserId;

import java.util.List;

@Service
public class UserIdServiceImpl extends ServiceImpl<UserIdMapper, UserId> implements UserIdService {

    @Resource
    private UserIdMapper userIdMapper;

    public List<UserId> queryBySelective(UserId record) {
        QueryWrapper<UserId> wrapper = new QueryWrapper<> (record);
        List<UserId> userIds = userIdMapper.selectList (wrapper);
        for (UserId info : userIds) {
            System.out.println (info.toString ());
        }
        return userIds;
    }

    public List<UserId> queryAll() {
        QueryWrapper<UserId> wrapper = new QueryWrapper<> ();
        return userIdMapper.selectList (wrapper);
    }
    public UserId queryByNumber(String number) {
        QueryWrapper<UserId> wrapper = new QueryWrapper<> ();
        wrapper.eq ("number",number);
        return userIdMapper.selectOne (wrapper);
    }

    public Boolean updateByUserId(UserId UserId) {
        UpdateWrapper<UserId> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("id", UserId.getId ());
        int result = userIdMapper.update (UserId, wrapper);
        return result > 0;
    }

    public Boolean addByUserId(UserId UserId) {
        int result = userIdMapper.insert (UserId);
        return result > 0;
    }

    public Boolean delByUserId(List<Integer> idList) {
        int result = userIdMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
