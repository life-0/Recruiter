package com.life.Service.user;

import com.life.POJO.user.JobHuntingInfo;

public interface JobHuntingInfoService {


    int deleteById(Integer id);

    int insert(JobHuntingInfo record);

    int insertSelective(JobHuntingInfo record);

    JobHuntingInfo selectByPrimaryKey(String number);

    JobHuntingInfo selectById(Integer id);

    JobHuntingInfo queryAll();

    int updateByIdSelective(JobHuntingInfo record);

    int updateByPrimaryKey(JobHuntingInfo record);

}
