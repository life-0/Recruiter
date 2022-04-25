package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.life.Mapper.user.JobFavoritesMapper;
import com.life.POJO.user.FirmInfo;
import com.life.POJO.user.JobFavorites;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.Mapper.user.ResumeDeliveryMapper;
import com.life.POJO.user.ResumeDelivery;
import com.life.Service.user.ResumeDeliveryService;

import java.util.List;

@Service
public class ResumeDeliveryServiceImpl extends MppServiceImpl<ResumeDeliveryMapper, ResumeDelivery> implements ResumeDeliveryService {

    @Resource
    private ResumeDeliveryMapper resumeDeliveryMapper;

    public List<ResumeDelivery> queryBySelective(ResumeDelivery record) {
        QueryWrapper<ResumeDelivery> wrapper = new QueryWrapper<> (record);
        return resumeDeliveryMapper.selectList (wrapper);
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
        int result = resumeDeliveryMapper.insert (resumeDelivery);
        return result > 0;
    }

    public Boolean delResumeDelivery(List<Integer> idList) {
        int result = resumeDeliveryMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
