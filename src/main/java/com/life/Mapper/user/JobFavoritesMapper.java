package com.life.Mapper.user;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.life.POJO.user.JobFavorites;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobFavoritesMapper  extends MppBaseMapper<JobFavorites> {
    int deleteByPrimaryKey(String number);

    int insert(JobFavorites record);

    int insertSelective(JobFavorites record);

    JobFavorites selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(JobFavorites record);

    int updateByPrimaryKey(JobFavorites record);
}