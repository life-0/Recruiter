package com.life.Controller.user;


import com.life.POJO.user.JobFavorites;
import com.life.Service.user.JobFavoritesServiceImpl;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 *@Author: life-0
 *@ClassName: JobFavoritesController
 *@Date: 2022/4/25 20:51
 *TODO @Description:

 */
@RestController
@RequestMapping("/jobFavorites")
@Api("企业信息接口")
public class JobFavoritesController {
    @Resource
    private JobFavoritesServiceImpl jobFavoritesService;

    @ApiOperation("随意条件查询")
    @PostMapping("/getJobFavorites")
    public Result<?> getJobFavorites(@RequestBody JobFavorites jobFavorites) {
        List<JobFavorites> jobFavoritess = jobFavoritesService.queryBySelective (jobFavorites);
        for (JobFavorites info : jobFavoritess) {
            System.out.println (info.toString ());
        }
        return Result.OK (jobFavoritess);
    }

    @ApiOperation("依据id查询")
    @PostMapping("/getJobFavoritesByUserId")
    public Result<?> getJobFavoritesByUserId(@RequestParam("userId") Integer userId) {
        System.out.println ("userId: " + userId);
        JobFavorites jobFavorites = jobFavoritesService.queryByUserId (userId);
        if (jobFavorites != null) {
            System.out.println ("-----------");
            return Result.OK (jobFavorites);
        } else {
            return Result.OK (new ArrayList<String> ());
        }
    }

    @PostMapping("/addJobFavorites")
    public Result<?> addJobFavorites(@RequestBody JobFavorites jobFavorites) {
        if (jobFavoritesService.addJobFavorites (jobFavorites)) {
            return Result.OK (true);
        } else {
            return Result.OK (false);
        }
    }

    @PostMapping("/updateJobFavorites")
    public Result<?> updateJobFavorites(@RequestBody JobFavorites jobFavorites) {
        System.out.println (jobFavorites.toString ());
        ArrayList<JobFavorites> list = new ArrayList<> ();
        if (jobFavoritesService.updateJobFavorites (jobFavorites)) {
            return Result.OK (getJobFavorites (new JobFavorites ().setUserId (jobFavorites.getUserId ())));
        } else {
            return Result.OK (list);
        }
    }

    @PostMapping("/delJobFavorites")
    public Result<?> delJobFavorites(@RequestBody List<Integer> idList) {

        if (jobFavoritesService.delJobFavorites (idList)) {
            return Result.OK ();
        } else {
            return Result.OK ("数据修改失败");
        }
    }
}
