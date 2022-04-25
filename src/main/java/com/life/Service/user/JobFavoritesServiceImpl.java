package com.life.Service.user;

import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.Mapper.user.JobFavoritesMapper;
import com.life.POJO.user.JobFavorites;
import com.life.Service.user.JobFavoritesService;
@Service
public class JobFavoritesServiceImpl extends MppServiceImpl<JobFavoritesMapper, JobFavorites> implements JobFavoritesService{

    @Resource
    private JobFavoritesMapper jobFavoritesMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return jobFavoritesMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int insert(JobFavorites record) {
        return jobFavoritesMapper.insert(record);
    }

    @Override
    public int insertSelective(JobFavorites record) {
        return jobFavoritesMapper.insertSelective(record);
    }

    @Override
    public JobFavorites selectByPrimaryKey(String number) {
        return jobFavoritesMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateByPrimaryKeySelective(JobFavorites record) {
        return jobFavoritesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(JobFavorites record) {
        return jobFavoritesMapper.updateByPrimaryKey(record);
    }

}
