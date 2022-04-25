package com.life.Service.user;

import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.life.Mapper.user.JobFavoritesMapper;
import com.life.POJO.user.JobFavorites;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.Mapper.user.ResumeDeliveryMapper;
import com.life.POJO.user.ResumeDelivery;
import com.life.Service.user.ResumeDeliveryService;
@Service
public class ResumeDeliveryServiceImpl extends MppServiceImpl<ResumeDeliveryMapper, ResumeDelivery> implements ResumeDeliveryService{

    @Resource
    private ResumeDeliveryMapper resumeDeliveryMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return resumeDeliveryMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int insert(ResumeDelivery record) {
        return resumeDeliveryMapper.insert(record);
    }

    @Override
    public int insertSelective(ResumeDelivery record) {
        return resumeDeliveryMapper.insertSelective(record);
    }

    @Override
    public ResumeDelivery selectByPrimaryKey(String number) {
        return resumeDeliveryMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateByPrimaryKeySelective(ResumeDelivery record) {
        return resumeDeliveryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ResumeDelivery record) {
        return resumeDeliveryMapper.updateByPrimaryKey(record);
    }

}
