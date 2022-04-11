package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.life.Mapper.user.UserResourceMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserResource;

import java.util.List;

@Service
public class UserResourceServiceImpl extends ServiceImpl<UserResourceMapper, UserResource> implements UserResourceService {

    @Resource
    private UserResourceMapper userResourceMapper;


    public List<UserResource> queryBySelective(UserResource record) {
        QueryWrapper<UserResource> wrapper = new QueryWrapper<> (record);
        List<UserResource> userResources = userResourceMapper.selectList (wrapper);
        for (UserResource info : userResources) {
            System.out.println (info.toString ());
        }
        return userResources;
    }

    public List<UserResource> queryAll() {
        QueryWrapper<UserResource> wrapper = new QueryWrapper<> ();
        return userResourceMapper.selectList (wrapper);
    }

    public Boolean updateUserResource(UserResource userResource) {
        UpdateWrapper<UserResource> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("id", userResource.getId ());
        int result = userResourceMapper.update (userResource, wrapper);
        return result > 0;
    }

    public Boolean addUserResource(UserResource userResource) {
        int result = userResourceMapper.insert (userResource);
        return result > 0;
    }

    public Boolean delUserResource(List<Integer> idList) {
        int result = userResourceMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
