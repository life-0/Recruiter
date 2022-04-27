package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.life.POJO.user.FirmInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.Mapper.user.JobFavoritesMapper;
import com.life.POJO.user.JobFavorites;
import com.life.Service.user.JobFavoritesService;

import java.util.List;

@Service
public class JobFavoritesServiceImpl extends MppServiceImpl<JobFavoritesMapper, JobFavorites> implements JobFavoritesService{

    @Resource
    private JobFavoritesMapper jobFavoritesMapper;


    public List<JobFavorites> queryBySelective(JobFavorites record) {
        QueryWrapper<JobFavorites> wrapper = new QueryWrapper<> (record);
        return jobFavoritesMapper.selectList (wrapper);
    }

    public List<JobFavorites> queryAll() {
        QueryWrapper<JobFavorites> wrapper = new QueryWrapper<> ();
        return jobFavoritesMapper.selectList (wrapper);
    }

    public JobFavorites queryById(Integer id) {
        QueryWrapper<JobFavorites> wrapper = new QueryWrapper<> ();
        wrapper.eq ("user_id", id);
        return jobFavoritesMapper.selectOne (wrapper);
    }

    public Boolean updateJobFavorites(JobFavorites jobFavorites) {
        UpdateWrapper<JobFavorites> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("user_id", jobFavorites.getUserId ());
        int result = jobFavoritesMapper.update (jobFavorites, wrapper);
        return result > 0;
    }

    public Boolean addJobFavorites(JobFavorites record) {
        List<JobFavorites> jobFavoritesList = queryBySelective (record);
        if (jobFavoritesList.isEmpty ()){
            int result = jobFavoritesMapper.insert (record);
            return result > 0;
        }else {
            return false;
        }

    }

    public Boolean delJobFavorites(List<Integer> idList) {
        int result = jobFavoritesMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
