package com.life.Controller.user;

import com.life.POJO.user.FirmInfo;
import com.life.Service.user.FirmInfoServiceImpl;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 *@Author: life-0
 *@ClassName: FirmController
 *@Date: 2022/4/23 22:59
 *TODO @Description:
            企业信息接口
 */
@RestController
@RequestMapping("/firm")
@Api("企业信息接口")
public class FirmController {
    @Resource
    private FirmInfoServiceImpl firmInfoService;

    @ApiOperation("随意条件查询")
    @PostMapping("/getFirmInfo")
    public Result<?> getFirmInfo(@RequestBody FirmInfo firmInfo) {
        List<FirmInfo> firmInfos = firmInfoService.queryBySelective (firmInfo);
        for (FirmInfo info : firmInfos) {
            System.out.println (info.toString ());
        }
        return Result.OK (firmInfos);
    }

    @ApiOperation("依据id查询")
    @PostMapping("/getFirmInfoById")
    public Result<?> getFirmInfoById(@RequestParam("firmId") Integer firmId) {
        System.out.println ("firmId: " + firmId);
        FirmInfo firmInfo = firmInfoService.queryById (firmId);
        if (firmInfo != null) {
            System.out.println ("-----------");
            return Result.OK (firmInfo);
        } else {
            return Result.OK (new ArrayList<String> ());
        }
    }

    @PostMapping("/addFirmInfo")
    public Result<?> addFirmInfo(@RequestBody FirmInfo firmInfo) {
        ArrayList<FirmInfo> list = new ArrayList<> ();
        if (firmInfoService.addFirmInfo (firmInfo)) {
            return Result.OK (list);
        } else {
            return Result.OK ("数据修改失败");
        }
    }

    @PostMapping("/updateFirmInfo")
    public Result<?> updateFirmInfo(@RequestBody FirmInfo firmInfo) {
        System.out.println (firmInfo.toString ());
        ArrayList<FirmInfo> list = new ArrayList<> ();
        if (firmInfoService.updateFirmInfo (firmInfo)) {
            return Result.OK (getFirmInfo (new FirmInfo ().setFirmId (firmInfo.getFirmId ())));
        } else {
            return Result.OK (list);
        }
    }

    @PostMapping("/delFirmInfo")
    public Result<?> delFirmInfo(@RequestBody List<Integer> idList) {

        if (firmInfoService.delFirmInfo (idList)) {
            return Result.OK ();
        } else {
            return Result.OK ("数据修改失败");
        }
    }

}
