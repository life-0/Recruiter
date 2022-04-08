package com.life.Controller.user;

import com.life.POJO.user.JobHuntingInfo;
import com.life.Service.user.JobHuntingInfoServiceImpl;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

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

    @PostMapping("/query")
    public Result<?> query(@RequestParam("id") Integer id) {
        JobHuntingInfo jobHuntingInfo = jobHuntingInfoService.selectById (id);
        return Result.ok (jobHuntingInfo);
    }

    @PostMapping("/update")
    public Result<?> update(@RequestBody JobHuntingInfo jobHuntingInfo) {
        int i = jobHuntingInfoService.updateByIdSelective (jobHuntingInfo);
        if (i != 0) {
            return Result.ok ();
        } else {
            return Result.ok ("数据修改失败");
        }
    }

    @PostMapping("/delete")
    public Result<?> delete(@RequestBody JobHuntingInfo jobHuntingInfo) {
        int i = jobHuntingInfoService.updateByIdSelective (jobHuntingInfo);
        if (i != 0) {
            return Result.ok ();
        } else {
            return Result.ok ("数据修改失败");
        }
    }

}
