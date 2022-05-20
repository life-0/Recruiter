package com.life.Mapper.user;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.life.POJO.user.JobFavorites;
import com.life.POJO.user.JobList;
import com.life.dto.JobListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobFavoritesMapper extends MppBaseMapper<JobFavorites> {
    List<JobListDTO> queryByUserId(Integer userId);
}