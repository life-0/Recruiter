package com.life.Controller.user;

import com.life.POJO.user.JobHuntingInfo;
import com.life.Service.user.JobHuntingInfoServiceImpl;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 *@Author: life-0
 *@ClassName: JobInfoController
 *@Date: 2022/4/8 10:16
 *TODO @Description: 用户求职信息接口

 */
@RestController
@RequestMapping("/job")
@Api("用户求职信息接口")
public class JobInfoController {
    @Resource
    private JobHuntingInfoServiceImpl jobHuntingInfoService;

    @PostMapping("/getJobHuntingInfo")
    public Result<?> getJobHuntingInfo(@RequestBody JobHuntingInfo jobHuntingInfo) {
        List<JobHuntingInfo> jobHuntingInfos = jobHuntingInfoService.queryBySelective (jobHuntingInfo);
        return Result.ok (jobHuntingInfos);
    }

    @PostMapping("/addJobHuntingInfo")
    public Result<?> addJobHuntingInfo(@RequestBody JobHuntingInfo jobHuntingInfo) {
        if (jobHuntingInfoService.addJobHuntingInfo (jobHuntingInfo)) {
            return Result.ok ();
        } else {
            return Result.ok ("数据修改失败");
        }
    }

    @PostMapping("/updateJobHuntingInfo")
    public Result<?> updateJobHuntingInfo(@RequestBody JobHuntingInfo jobHuntingInfo) {
        System.out.println (jobHuntingInfo.toString ());
        if (jobHuntingInfoService.updateJobHuntingInfo (jobHuntingInfo)) {
            return Result.ok ();
        } else {
            return Result.ok ("数据修改失败");
        }
    }

    @PostMapping("/delJobHuntingInfo")
    public Result<?> delJobHuntingInfo(@RequestBody List<Integer> idList) {

        if (jobHuntingInfoService.delJobHuntingInfo (idList)) {
            return Result.ok ();
        } else {
            return Result.ok ("数据修改失败");
        }
    }

}
