package com.life.Mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.life.POJO.user.JobHuntingInfo;
import com.life.POJO.user.JobList;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface JobListMapper extends BaseMapper<JobList> {
}