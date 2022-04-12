package com.life.Service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.Mapper.user.JobHuntingInfoMapper;
import com.life.POJO.user.JobHuntingInfo;

import java.util.List;

@Service
public class JobHuntingInfoServiceImpl extends ServiceImpl<JobHuntingInfoMapper, JobHuntingInfo> implements JobHuntingInfoService {


    @Resource
    private JobHuntingInfoMapper JobHuntingInfoMapper;

    public List<JobHuntingInfo> queryBySelective(JobHuntingInfo record) {
        QueryWrapper<JobHuntingInfo> wrapper = new QueryWrapper<> (record);
        List<JobHuntingInfo> JobHuntingInfos = JobHuntingInfoMapper.selectList (wrapper);
        for (JobHuntingInfo info : JobHuntingInfos) {
            System.out.println (info.toString ());
        }
        return JobHuntingInfos;
    }

    public List<JobHuntingInfo> queryAll() {
        QueryWrapper<JobHuntingInfo> wrapper = new QueryWrapper<> ();
        return JobHuntingInfoMapper.selectList (wrapper);
    }

    public Boolean updateJobHuntingInfo(JobHuntingInfo JobHuntingInfo) {
        UpdateWrapper<JobHuntingInfo> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("id", JobHuntingInfo.getId ());
        int result = JobHuntingInfoMapper.update (JobHuntingInfo, wrapper);
        return result > 0;
    }

    public Boolean addJobHuntingInfo(JobHuntingInfo JobHuntingInfo) {
        int result = JobHuntingInfoMapper.insert (JobHuntingInfo);
        return result > 0;
    }

    public Boolean delJobHuntingInfo(List<Integer> idList) {
        int result = JobHuntingInfoMapper.deleteBatchIds (idList);
        return result > 0;
    }

  }

