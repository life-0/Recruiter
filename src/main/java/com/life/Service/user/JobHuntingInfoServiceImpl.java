package com.life.Service.user;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.Mapper.user.JobHuntingInfoMapper;
import com.life.POJO.user.JobHuntingInfo;

@Service
public class JobHuntingInfoServiceImpl implements JobHuntingInfoService {

    @Resource
    private JobHuntingInfoMapper jobHuntingInfoMapper;

    @Override
    public int deleteById(Integer id) {
        return jobHuntingInfoMapper.deleteById (id);
    }

    @Override
    public int insert(JobHuntingInfo record) {
        return jobHuntingInfoMapper.insert (record);
    }

    @Override
    public int insertSelective(JobHuntingInfo record) {
        return jobHuntingInfoMapper.insertSelective (record);
    }

    @Override
    public JobHuntingInfo selectByPrimaryKey(String number) {
        return jobHuntingInfoMapper.selectByPrimaryKey (number);
    }

    @Override
    public JobHuntingInfo selectById(Integer id) {
        return jobHuntingInfoMapper.selectById (id);
    }

    @Override
    public JobHuntingInfo queryAll() {
        return jobHuntingInfoMapper.queryAll ();
    }

    @Override
    public int updateByIdSelective(JobHuntingInfo record) {
//        LambdaUpdateWrapper<JobHuntingInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<> ();
//        lambdaUpdateWrapper.eq(JobHuntingInfo::getName, "rhb").set(User::getAge, 18);
//        Integer rows = userMapper.update(null, lambdaUpdateWrapper);
        return jobHuntingInfoMapper.updateByIdSelective (record);
    }

    @Override
    public int updateByPrimaryKey(JobHuntingInfo record) {
        return jobHuntingInfoMapper.updateByPrimaryKey (record);
    }

}
