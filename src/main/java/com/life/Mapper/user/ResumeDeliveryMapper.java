package com.life.Mapper.user;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;

import com.life.POJO.user.ResumeDelivery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResumeDeliveryMapper extends MppBaseMapper<ResumeDelivery> {
    int deleteByPrimaryKey(String number);

    int insert(ResumeDelivery record);

    int insertSelective(ResumeDelivery record);

    ResumeDelivery selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(ResumeDelivery record);

    int updateByPrimaryKey(ResumeDelivery record);
}