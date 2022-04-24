package com.life.Mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.life.POJO.user.FirmInfo;
import com.life.POJO.user.JobHuntingInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FirmInfoMapper  extends MppBaseMapper<FirmInfo> {

}