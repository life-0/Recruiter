package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.life.Mapper.user.JobHuntingInfoMapper;
import com.life.Mapper.user.UserInfoMapper;
import com.life.POJO.user.FirmInfo;
import com.life.POJO.user.JobHuntingInfo;
import com.life.POJO.user.UserInfo;
import com.life.Utils.NumberUtil;
import com.life.bo.JobListBO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.JobList;
import com.life.Mapper.user.JobListMapper;
import com.life.Service.user.JobListService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobListServiceImpl extends ServiceImpl<JobListMapper, JobList> implements JobListService {
    @Resource
    private JobListMapper jobListMapper;

    @Resource
    private FirmInfoServiceImpl firmInfoService;

    public List<JobList> queryBySelective(JobList record) {
        QueryWrapper<JobList> wrapper = new QueryWrapper<> (record);
        List<JobList> jobLists = jobListMapper.selectList (wrapper);
        for (JobList info : jobLists) {
            System.out.println (info.toString ());
        }
        return jobLists;
    }

    public JobList queryById(Integer id) {
        return jobListMapper.selectById (id);
    }


    public List<JobListBO> fuzzyQueryJobList(JobList jobList) {
        QueryWrapper<JobList> wrapper = new QueryWrapper<> ();
        if (jobList.getPosition () != null) {
            wrapper.like ("position", jobList.getPosition ());
        } else if (jobList.getSalary () != null) {
            wrapper.like ("salary", jobList.getPosition ());
        } else if (jobList.getAddress () != null) {
            wrapper.like ("address", jobList.getAddress ());
        } else if (jobList.getNature () != null) {
            wrapper.like ("nature", jobList.getNature ());
        } else if (jobList.getApplicationConditions () != null) {
            wrapper.like ("application_conditions", jobList.getApplicationConditions ());
        }

        //带上公司信息
        ArrayList<JobListBO> jobListBOS = new ArrayList<> ();
        List<JobList> jobLists = jobListMapper.selectList (wrapper);
        for (JobList job : jobLists) {
            FirmInfo firmInfo = firmInfoService.queryById (job.getFirmId ());
            jobListBOS.add (new JobListBO (job, firmInfo));
        }
        return jobListBOS;
    }


    public List<JobList> queryAll() {
        QueryWrapper<JobList> wrapper = new QueryWrapper<> ();
        return jobListMapper.selectList (wrapper);
    }

    public Boolean updateJobList(JobList jobList) {
        UpdateWrapper<JobList> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("number", jobList.getNumber ());
        wrapper.eq ("id", jobList.getId ());
        int result = jobListMapper.update (jobList, wrapper);
        return result > 0;
    }

    public Boolean addJobList(JobList jobList) {

        jobList.setNumber (NumberUtil.getRandomNumber ());
        jobList.setCreateTime (new Date ());
        int result = jobListMapper.insert (jobList);
        return result > 0;
    }

    public Boolean delJobList(String number, Integer id) {
        QueryWrapper<JobList> wrapper = new QueryWrapper<> ();
        wrapper.eq ("number", number);
        wrapper.eq ("id", id);
        int result = jobListMapper.delete (wrapper);
        return result > 0;
    }
}
