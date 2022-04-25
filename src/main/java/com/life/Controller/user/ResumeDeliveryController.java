package com.life.Controller.user;


import com.life.POJO.user.ResumeDelivery;
import com.life.Service.user.ResumeDeliveryServiceImpl;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 *@Author: life-0
 *@ClassName: ResumeDeliveryController
 *@Date: 2022/4/25 20:50
 *TODO @Description:

 */
@RestController
@RequestMapping("/resumeDelivery")
@Api("简历投递接口")
public class ResumeDeliveryController {
    @Resource
    private ResumeDeliveryServiceImpl resumeDeliveryService;

    @ApiOperation("随意条件查询")
    @PostMapping("/getResumeDelivery")
    public Result<?> getResumeDelivery(@RequestBody ResumeDelivery jobFavorites) {
        List<ResumeDelivery> jobFavoritess = resumeDeliveryService.queryBySelective (jobFavorites);
        for (ResumeDelivery info : jobFavoritess) {
            System.out.println (info.toString ());
        }
        return Result.OK (jobFavoritess);
    }

    @ApiOperation("依据id查询")
    @PostMapping("/getResumeDeliveryById")
    public Result<?> getResumeDeliveryById(@RequestParam("id") Integer id) {
        System.out.println ("id: " + id);
        ResumeDelivery jobFavorites = resumeDeliveryService.queryById (id);
        if (jobFavorites != null) {
            System.out.println ("-----------");
            return Result.OK (jobFavorites);
        } else {
            return Result.OK (new ArrayList<String> ());
        }
    }

    @PostMapping("/addResumeDelivery")
    public Result<?> addResumeDelivery(@RequestBody ResumeDelivery jobFavorites) {
        ArrayList<ResumeDelivery> list = new ArrayList<> ();
        if (resumeDeliveryService.addResumeDelivery (jobFavorites)) {
            return Result.OK (list);
        } else {
            return Result.OK ("数据修改失败");
        }
    }

    @PostMapping("/updateResumeDelivery")
    public Result<?> updateResumeDelivery(@RequestBody ResumeDelivery jobFavorites) {
        System.out.println (jobFavorites.toString ());
        ArrayList<ResumeDelivery> list = new ArrayList<> ();
        if (resumeDeliveryService.updateResumeDelivery (jobFavorites)) {

            return Result.OK (getResumeDelivery ( new ResumeDelivery ().setUserId (jobFavorites.getUserId ())));
        } else {
            return Result.OK (list);
        }
    }

    @PostMapping("/delResumeDelivery")
    public Result<?> delResumeDelivery(@RequestBody List<Integer> idList) {

        if (resumeDeliveryService.delResumeDelivery (idList)) {
            return Result.OK ();
        } else {
            return Result.OK ("数据修改失败");
        }
    }
}
