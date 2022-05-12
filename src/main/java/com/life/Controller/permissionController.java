package com.life.Controller;

import com.life.POJO.user.UserInfo;
import com.life.POJO.user.UserLogin;
import com.life.POJO.user.UserRank;
import com.life.Service.user.UserInfoServiceImpl;
import com.life.Service.user.UserRankServiceImpl;
import com.life.Utils.redisUtil;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 *@Author: life-0
 *@ClassName: permissionController
 *@Date: 2022/1/13 14:26
 *TODO @Description:
                    权限管理控制层
 */
@RestController
@Api("权限层")
@RequestMapping("/permission")
public class permissionController {
    @Resource
    private UserRankServiceImpl userRankService;
    @Autowired
    private redisUtil redisImpl;
    @ApiOperation("展示所有的用户权限")
    @PostMapping("/getUserRank")
    public Result<?> getUserRank(@RequestBody UserRank userRank) {
        System.out.println (userRank.toString ());
        List<UserRank> userRanks = null;
        if (userRank != null) {
            System.out.println ("-----------");
            userRanks = userRankService.queryBySelective (userRank);
        } else {
            userRanks = userRankService.queryAll ();
        }
        return Result.ok (userRanks);
    }

    @ApiOperation("依据Id查询权限")
    @PostMapping("/getUserRankById")
    public Result<?> getUserRankById(@RequestParam("id") Integer id) {
        System.out.println ("id: "+id);
        UserRank userRank = userRankService.queryById (id);
        if (userRank != null) {
            System.out.println ("-----------");
            return Result.ok (userRank);
        } else {
            return Result.ok (new ArrayList<String> ());
        }
    }
    @ApiOperation("根据token查询redis已登录的账号")
    @PostMapping("/getUserRankByToken")
    public Result<?> getUserRankById(@RequestParam("token") String token) {
        System.out.println ("token: "+token);
        UserLogin userLogin =(UserLogin) redisImpl.get (token);
        if (userLogin.getId ()!=null){
            UserRank userRank = userRankService.queryById (userLogin.getId ());
            if (userRank != null) {
                System.out.println ("-----------");
                return Result.ok (userRank);
            } else {
                return Result.ok (new ArrayList<String> ());
            }
        }
//        UserRank userRank = userRankService.queryById (id);
        else {
            return Result.ok (new ArrayList<String> ());
        }

    }

    @PostMapping(value = {"/updateUserRank"})
    public Result<?> updateUserRank(@RequestBody UserRank userRank) {
        System.out.println (userRank.toString ());
        if (userRankService.updateUserRank (userRank)) {
            return getUserRank (new UserRank ().setId (userRank.getId ()));
        } else {
            List<String> list = new ArrayList<> ();
            return Result.OK (list);
        }
    }


    @PostMapping("/addUserRank")
    public Result<?> addUserRank(@RequestBody UserRank userRank) {
        if (userRankService.addUserRank (userRank)) {
            return getUserRank (new UserRank ().setId (userRank.getId ()));
        } else {
            List<String> list = new ArrayList<> ();
            return Result.OK (list);
        }
    }

    @PostMapping("/delUserRank")
    public Result<?> delUserRank(@RequestBody List<Integer> idList) {
        List<String> list = new ArrayList<> ();
        if (userRankService.delUserRank (idList)) {
            return Result.OK ("ok");
        } else {
            return Result.OK (list);
        }
    }
}
