package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.life.Mapper.user.JobFavoritesMapper;
import com.life.Mapper.user.UserInfoMapper;
import com.life.POJO.user.*;
import com.life.bo.ResumeDeliveryBO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.Mapper.user.ResumeDeliveryMapper;
import com.life.Service.user.ResumeDeliveryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeDeliveryServiceImpl extends MppServiceImpl<ResumeDeliveryMapper, ResumeDelivery> implements ResumeDeliveryService {

    @Resource
    private ResumeDeliveryMapper resumeDeliveryMapper;

    @Resource
    private UserInfoServiceImpl userInfoService;

    @Resource
    private JobHuntingInfoServiceImpl jobHuntingInfoService;

    public List<ResumeDelivery> queryBySelective(ResumeDelivery record) {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> (record);
        return resumeDeliveryMapper.selectList (wrapper);
    }

    public List<ResumeDeliveryBO> getUserInfoJobHuntingInfo(ResumeDelivery record) {
        ArrayList<ResumeDeliveryBO> list = new ArrayList<> ();
        //返回用户信息,用户求职信息,用户简历投递信息
        for (ResumeDelivery resumeDelivery : queryBySelective (record)) {
            ResumeDeliveryBO resumeDeliveryBO = new ResumeDeliveryBO ();
            UserInfo userInfo = userInfoService.queryById (resumeDelivery.getUserId ());
            JobHuntingInfo jobHuntingInfo = jobHuntingInfoService.queryById (resumeDelivery.getUserId ());
            resumeDeliveryBO.setUserInfo (userInfo);
            resumeDeliveryBO.setJobHuntingInfo (jobHuntingInfo);
            resumeDeliveryBO.setResumeDelivery (resumeDelivery);
            list.add (resumeDeliveryBO);
        }


        return list;
    }


    public List<ResumeDelivery> queryAll() {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> ();
        return resumeDeliveryMapper.selectList (wrapper);
    }

    public ResumeDelivery queryById(Integer id) {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> ();
        wrapper.eq ("firm_id", id);
        return resumeDeliveryMapper.selectOne (wrapper);
    }

    public Boolean updateResumeDelivery(ResumeDelivery resumeDelivery) {
        UpdateWrapper<ResumeDelivery> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("firm_id", resumeDelivery.getFirmId ());
        int result = resumeDeliveryMapper.update (resumeDelivery, wrapper);
        return result > 0;
    }

    public Boolean addResumeDelivery(ResumeDelivery resumeDelivery) {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> ();
        wrapper.eq ("firm_id", resumeDelivery.getFirmId ());
        wrapper.eq ("job_number", resumeDelivery.getJobNumber ());
        wrapper.eq ("user_id", resumeDelivery.getUserId ());
        List<ResumeDelivery> resumeDeliveries = resumeDeliveryMapper.selectList (wrapper);
        if (resumeDeliveries.isEmpty ()) {
            return resumeDeliveryMapper.insert (resumeDelivery) > 0;
        } else {
            return false;
        }

    }

    public Boolean delResumeDelivery(List<Integer> idList) {
        int result = resumeDeliveryMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
