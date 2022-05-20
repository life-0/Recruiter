package com.life.Service.user;

import com.github.jeffreyning.mybatisplus.service.IMppService;
import com.life.POJO.user.JobFavorites;
import com.life.dto.JobListDTO;

import java.util.List;

public interface JobFavoritesService extends IMppService<JobFavorites> {
    List<JobListDTO> queryByUserId(Integer userId);


}
