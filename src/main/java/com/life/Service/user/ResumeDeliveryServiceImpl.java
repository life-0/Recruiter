package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.life.POJO.user.*;
import com.life.bo.JobListBO;
import com.life.bo.ResumeDeliveryBO;
import com.life.dto.ResumeDeliveryFirmInfoDTO;
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
    private JobListServiceImpl jobListServiceImpl;


    public List<ResumeDelivery> queryBySelective(ResumeDelivery record) {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> (record);
        return resumeDeliveryMapper.selectList (wrapper);
    }


    public List<ResumeDeliveryFirmInfoDTO> getJobInfoJobHuntingInfo(ResumeDelivery record) {
        ArrayList<ResumeDeliveryFirmInfoDTO> list = new ArrayList<> ();
        //返回公司名字,福利信息,职位信息,用户投递结果信息,简历

        List<ResumeDelivery> resumeDeliveries = queryBySelective (record);
        for (ResumeDelivery resumeDelivery : resumeDeliveries) {
            ResumeDeliveryFirmInfoDTO resumeDeliveryFirmInfoBO = new ResumeDeliveryFirmInfoDTO ();
            JobListBO jobListBO = jobListServiceImpl.queryJobListFirmInfo (resumeDelivery.getJobNumber ());
            resumeDeliveryFirmInfoBO.setJobList (jobListBO.getJobList ());
            resumeDeliveryFirmInfoBO.setFirmName (jobListBO.getFirmInfo ().getFirmName ());
            resumeDeliveryFirmInfoBO.setFirmWelfare (jobListBO.getFirmInfo ().getWelfare ());
            resumeDeliveryFirmInfoBO.setResumeDeliveryIsOnlineResume (resumeDelivery.getIsOnlineResume ());
            resumeDeliveryFirmInfoBO.setResumeDeliveryResult (resumeDelivery.getResult ());
            list.add (resumeDeliveryFirmInfoBO);
        }
        return list;
    }


    public List<ResumeDelivery> queryAll() {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> ();
        return resumeDeliveryMapper.selectList (wrapper);
    }

    public ResumeDelivery queryByFirmId(Integer firmId) {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> ();
        wrapper.eq ("firm_id", firmId);
        return resumeDeliveryMapper.selectOne (wrapper);
    }

    public List<ResumeDelivery> queryByUserId(Integer userId) {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> ();
        wrapper.eq ("user_id", userId);
        return resumeDeliveryMapper.selectList (wrapper);
    }

    public Boolean updateResumeDelivery(ResumeDelivery resumeDelivery) {
        UpdateWrapper<ResumeDelivery> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("job_number", resumeDelivery.getJobNumber ());
        wrapper.eq ("user_id", resumeDelivery.getUserId ());
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
