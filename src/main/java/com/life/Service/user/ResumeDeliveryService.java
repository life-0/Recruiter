package com.life.Service.user;

import com.github.jeffreyning.mybatisplus.service.IMppService;
import com.life.POJO.user.ResumeDelivery;
public interface ResumeDeliveryService extends IMppService<ResumeDelivery> {


    int deleteByPrimaryKey(String number);

    int insert(ResumeDelivery record);

    int insertSelective(ResumeDelivery record);

    ResumeDelivery selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(ResumeDelivery record);

    int updateByPrimaryKey(ResumeDelivery record);

}
