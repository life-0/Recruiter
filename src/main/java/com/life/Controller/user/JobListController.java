package com.life.Controller.user;

import com.life.POJO.user.JobList;

import com.life.Service.user.JobListServiceImpl;

import com.life.Utils.NumberUtil;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 *@Author: life-0
 *@ClassName: JobListController
 *@Date: 2022/4/21 15:33
 *TODO @Description:

 */
@RestController
@Api("职位接口")
@RequestMapping("/jobList")
public class JobListController {
    @Resource
    private JobListServiceImpl jobListService;

    @ApiOperation("有条件查询")
    @PostMapping("/getJobList")
    public Result<?> getJobList(@RequestBody JobList jobList) {
        System.out.println (jobList.toString ());
        List<JobList> jobLists = null;
        jobLists = jobListService.queryBySelective (jobList);
        return Result.OK (jobLists);
    }

    @ApiOperation("通过UserID和FirmId查询")
    @PostMapping("/getJobListByUserIDFirmID")
    public Result<?> getJobListByUserIDFirmID(@RequestParam("announcerId") Integer announcerId, @RequestParam("firmId") Integer firmId) {
        List<JobList> jobLists = null;
        if (announcerId != 0 && firmId != 0) {
            jobLists = jobListService.getJobListByUserIDFirmId (announcerId, firmId);
        }
        return Result.OK (jobLists);
    }

    @ApiOperation("通过FirmId查询")
    @PostMapping("/getJobListByFirmId")
    public Result<?> getJobListByFirmID(@RequestParam("firmId") Integer firmId) {
        List<JobList> jobLists = null;
        if (firmId != 0) {
            jobLists = jobListService.getJobListByFirmId (firmId);
        }
        return Result.OK (jobLists);
    }

    @ApiOperation("模糊查询")
    @PostMapping("/getFuzzyQuery")
    public Result<?> fuzzyQueryJobList(@RequestBody JobList jobList) {

        if (jobList != null) {
            return Result.OK (jobListService.fuzzyQueryJobList (jobList));
        } else {
            return Result.OK (new ArrayList<String> ());
        }
    }

    @PostMapping(value = {"/updateJobList"})
    public Result<?> updateJobList(@RequestBody JobList jobList) {
        System.out.println (jobList.toString ());
        if (jobListService.updateJobList (jobList)) {
            return getJobList (new JobList ().setAnnouncerId (jobList.getAnnouncerId ()));
        } else {
            List<String> list = new ArrayList<> ();
            return Result.OK (list);
        }
    }


    @PostMapping("/addJobList")
    public Result<?> addJobList(@RequestBody JobList jobList) {
        if (jobListService.addJobList (jobList)) {
            return getJobList (new JobList ().setAnnouncerId (jobList.getAnnouncerId ()));
        } else {
            List<String> list = new ArrayList<> ();
            return Result.OK (list);
        }
    }

    @PostMapping("/delJobList")
    public Result<?> delJobList(@RequestParam("number") String number, @RequestParam("id") Integer id) {
        List<String> list = new ArrayList<> ();
        if (jobListService.delJobList (number, id)) {
            return Result.OK (getJobList (new JobList ().setAnnouncerId (id)));
        } else {
            return Result.OK (list);
        }
    }
}
