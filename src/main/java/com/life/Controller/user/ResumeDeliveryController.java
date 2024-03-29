package com.life.Controller.user;


import com.life.POJO.user.ResumeDelivery;
import com.life.Service.user.ResumeDeliveryServiceImpl;
import com.life.api.vo.Result;
import com.life.bo.ResumeDeliveryBO;
import com.life.dto.ResumeDeliveryFirmInfoDTO;
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
    public Result<?> getResumeDelivery(@RequestBody ResumeDelivery resumeDelivery) {
        List<ResumeDelivery> jobFavorite = resumeDeliveryService.queryBySelective (resumeDelivery);
        for (ResumeDelivery info : jobFavorite) {
            System.out.println (info.toString ());
        }
        return Result.OK (jobFavorite);
    }

//    @ApiOperation("获取用户简历信息")
//    @PostMapping("/getUserInfoJobHuntingInfo")
//    public Result<?> getUserInfoJobHuntingInfo(@RequestBody ResumeDelivery resumeDelivery) {
//        List<ResumeDeliveryBO> resumeDeliveryBOS = resumeDeliveryService.getUserInfoJobHuntingInfo (resumeDelivery);
//        return Result.OK (resumeDeliveryBOS);
//    }

    @ApiOperation("获取投递职位结果信息")
    @PostMapping("/getJobInfoJobHuntingInfo")
    public Result<?> getJobInfoJobHuntingInfo(@RequestBody ResumeDelivery resumeDelivery) {
        List<ResumeDeliveryFirmInfoDTO> jobInfoJobHuntingInfo = resumeDeliveryService.getJobInfoJobHuntingInfo (resumeDelivery);
        return Result.OK (jobInfoJobHuntingInfo);
    }


    @ApiOperation("依据Firmid查询")
    @PostMapping("/getResumeDeliveryByFirmId")
    public Result<?> getResumeDeliveryByFirmId(@RequestParam("id") Integer id) {
        System.out.println ("id: " + id);
        ResumeDelivery resumeDelivery = resumeDeliveryService.queryByFirmId (id);
        if (resumeDelivery != null) {
            return Result.OK (resumeDelivery);
        } else {
            return Result.OK (new ArrayList<String> ());
        }
    }

    @ApiOperation("依据UserId查询")
    @PostMapping("/getResumeDeliveryByUserId")
    public Result<?> getResumeDeliveryByUserId(@RequestParam("userId") Integer userId) {
        System.out.println ("id: " + userId);
        List<ResumeDelivery> resumeDeliveries = resumeDeliveryService.queryByUserId (userId);
        if (resumeDeliveries != null) {
            return Result.OK (resumeDeliveries);
        } else {
            return Result.OK (new ArrayList<String> ());
        }
    }

    @PostMapping("/addResumeDelivery")
    public Result<?> addResumeDelivery(@RequestBody ResumeDelivery resumeDelivery) {
        ArrayList<String> list = new ArrayList<> ();
        if (resumeDeliveryService.addResumeDelivery (resumeDelivery)) {
            return Result.OK ("申请成功!");
        } else {
            return Result.OK ("已申请,请勿重复申请!");
        }
    }

    @PostMapping("/updateResumeDelivery")
    public Result<?> updateResumeDelivery(@RequestBody ResumeDelivery resumeDelivery) {
        System.out.println (resumeDelivery.toString ());
        ArrayList<ResumeDelivery> list = new ArrayList<> ();
        if (resumeDeliveryService.updateResumeDelivery (resumeDelivery)) {

            return Result.OK (getResumeDelivery (new ResumeDelivery ().setUserId (resumeDelivery.getUserId ())));
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
