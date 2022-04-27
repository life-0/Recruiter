package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.user.FirmInfo;
import com.life.Mapper.user.FirmInfoMapper;
import com.life.Service.user.FirmInfoService;

import java.util.List;

@Service
public class FirmInfoServiceImpl extends MppServiceImpl<FirmInfoMapper, FirmInfo> implements FirmInfoService {

    @Resource
    private FirmInfoMapper firmInfoMapper;

    public List<FirmInfo> queryBySelective(FirmInfo record) {
        QueryWrapper<FirmInfo> wrapper = new QueryWrapper<> (record);
        return firmInfoMapper.selectList (wrapper);
    }

    public List<FirmInfo> queryAll() {
        QueryWrapper<FirmInfo> wrapper = new QueryWrapper<> ();
        return firmInfoMapper.selectList (wrapper);
    }

    public FirmInfo queryById(Integer firmId) {
        QueryWrapper<FirmInfo> wrapper = new QueryWrapper<> ();
        wrapper.eq ("firm_id", firmId);
        return firmInfoMapper.selectOne (wrapper);
    }

    public Boolean updateFirmInfo(FirmInfo FirmInfo) {
        UpdateWrapper<FirmInfo> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("firm_id", FirmInfo.getFirmId ());
        int result = firmInfoMapper.update (FirmInfo, wrapper);
        return result > 0;
    }

    public Boolean addFirmInfo(FirmInfo FirmInfo) {
        int result = firmInfoMapper.insert (FirmInfo);
        return result > 0;
    }

    public Boolean delFirmInfo(List<Integer> idList) {
        int result = firmInfoMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
