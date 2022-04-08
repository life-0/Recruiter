package com.life.Mapper.user;


import com.life.POJO.user.JobHuntingInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobHuntingInfoMapper {
    int deleteById(String id);

    int insert(JobHuntingInfo record);

    int insertSelective(JobHuntingInfo record);

    JobHuntingInfo selectByPrimaryKey(String number);

    JobHuntingInfo selectById(Integer id);

    JobHuntingInfo queryAll();

    int updateByIdSelective(JobHuntingInfo record);

    int updateByPrimaryKey(JobHuntingInfo record);
}