package com.life.Service.user;

import com.github.jeffreyning.mybatisplus.service.IMppService;
import com.life.POJO.user.JobFavorites;
public interface JobFavoritesService extends IMppService<JobFavorites> {


    int deleteByPrimaryKey(String number);

    int insert(JobFavorites record);

    int insertSelective(JobFavorites record);

    JobFavorites selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(JobFavorites record);

    int updateByPrimaryKey(JobFavorites record);

}
