package com.life.Service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.life.Mapper.user.ResumeDeliveryMapper;
import com.life.Mapper.user.UserInfoMapper;
import com.life.POJO.user.JobHuntingInfo;
import com.life.POJO.user.ResumeDelivery;
import com.life.POJO.user.UserLogin;
import com.life.bo.ResumeDeliveryBO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.UserInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private JobHuntingInfoServiceImpl jobHuntingInfoService;
    @Resource
    private ResumeDeliveryServiceImpl resumeDeliveryService;

    public List<UserInfo> queryBySelective(UserInfo record) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<> (record);
        List<UserInfo> userInfos = userInfoMapper.selectList (wrapper);
        for (UserInfo info : userInfos) {
            System.out.println (info.toString ());
        }
        return userInfos;
    }

    public UserInfo queryById(Integer id) {
        return userInfoMapper.selectById (id);
    }

    public List<UserInfo> getUserAvatarById(List<Integer> ids) {
        return userInfoMapper.getUserAvatarById (ids);

    }

    public List<UserInfo> queryAll() {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<> ();
        return userInfoMapper.selectList (wrapper);
    }

    public Boolean updateUserInfo(UserInfo userInfo) {
        UpdateWrapper<UserInfo> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("id", userInfo.getId ());
        int result = userInfoMapper.update (userInfo, wrapper);
        return result > 0;
    }

    public Boolean addUserInfo(UserInfo userInfo) {
        int result = userInfoMapper.insert (userInfo);
        return result > 0;
    }

    public Boolean delUserInfo(List<Integer> idList) {
        int result = userInfoMapper.deleteBatchIds (idList);
        return result > 0;
    }

    public List<ResumeDeliveryBO> getUserInfoJobHuntingInfo(UserInfo record) {
        ArrayList<ResumeDeliveryBO> list = new ArrayList<> ();

        //返回用户信息,用户求职信息,用户简历投递信息
        for (UserInfo userInfo : queryBySelective (record)) {
            ResumeDeliveryBO resumeDeliveryBO = new ResumeDeliveryBO ();
            List<ResumeDelivery> resumeDeliveries = resumeDeliveryService.queryByUserId (userInfo.getId ());
            JobHuntingInfo jobHuntingInfo = jobHuntingInfoService.queryById (userInfo.getId ());
            // 获取用户基础信息
            resumeDeliveryBO.setUserInfo (userInfo);
            //  获取用户求职信息
            resumeDeliveryBO.setJobHuntingInfo (jobHuntingInfo);
            //  获取用户职位投递信息
            resumeDeliveryBO.setResumeDelivery (resumeDeliveries);
            list.add (resumeDeliveryBO);
        }
        return list;
    }

}

