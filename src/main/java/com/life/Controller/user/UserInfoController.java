package com.life.Controller.user;

import com.life.POJO.user.UserInfo;
import com.life.POJO.user.UserRank;
import com.life.Service.user.UserInfoServiceImpl;
import com.life.api.vo.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/*
 *@Author: life-0
 *@ClassName: UserInfoController
 *@Date: 2022/4/6 15:33
 *TODO @Description:    用户信息接口

 */
@RestController
@Api("用户信息接口")
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoServiceImpl userInfoService;

    @ApiOperation("展示所有的用户")
    @PostMapping("/getUserInfo")
    public Result<?> getUserInfo(@RequestBody UserInfo userInfo) {
        System.out.println (userInfo.toString ());
        List<UserInfo> userInfos = null;
        if (userInfo != null) {
            System.out.println ("-----------");
            userInfos = userInfoService.queryBySelective (userInfo);
        } else {
            userInfos = userInfoService.queryAll ();
        }
        return Result.OK (userInfos);
    }

    @ApiOperation("依据id查询")
    @PostMapping("/getUserInfoById")
    public Result<?> getUserInfoById(@RequestParam("id") Integer id) {
        System.out.println ("id: " + id);
        UserInfo userInfo = userInfoService.queryById (id);
        if (userInfo != null) {
            System.out.println ("-----------");
            return Result.OK (userInfo);
        } else {
            return Result.OK (new ArrayList<String> ());
        }
    }

    @ApiOperation("获取头像")
    @PostMapping("/getUserAvatarById")
    public Result<?> getUserAvatarById(@RequestBody  List<Integer> ids) {
        System.out.println (ids.toString ()+"`````````````````````");
        List<UserInfo> userAvatars = userInfoService.getUserAvatarById (ids);
        if (userAvatars != null) {
            return Result.OK (userAvatars);
        } else {
            return Result.OK (new ArrayList<String> ());
        }
    }


    @PostMapping(value = {"/updateUserInfo"})
    public Result<?> updateUserInfo(@RequestBody UserInfo userInfo) {
        System.out.println (userInfo.toString ());
        if (userInfoService.updateUserInfo (userInfo)) {
            return getUserInfo (new UserInfo ().setId (userInfo.getId ()));
        } else {
            List<String> list = new ArrayList<> ();
            return Result.OK (list);
        }
    }


    @PostMapping("/addUserInfo")
    public Result<?> addUserInfo(@RequestBody UserInfo userInfo) {
        if (userInfoService.addUserInfo (userInfo)) {
            return getUserInfo (new UserInfo ().setId (userInfo.getId ()));
        } else {
            List<String> list = new ArrayList<> ();
            return Result.OK (list);
        }
    }

    @PostMapping("/delUserInfo")
    public Result<?> delUserInfo(@RequestBody List<Integer> idList) {
        List<String> list = new ArrayList<> ();
        if (userInfoService.delUserInfo (idList)) {
            return Result.OK ("ok");
        } else {
            return Result.OK (list);
        }
    }


//    @RequestMapping(value = {"/toAdd"}, method = RequestMethod.POST)
//    public String ToAdd(@RequestBody UserInfo userInfo) throws JSONException {
//        // Map<String , Object> map
//        NumberUtil number = new NumberUtil ();
//        System.out.println (userInfo.toString ());
////        userInfoService.insert (userInfo);
//        return "ok";
//    }

//    @ApiOperation("删除用户")
//    @RequestMapping(value = "/deleteStu", method = RequestMethod.DELETE)
//    @ResponseBody
//    public String deleteUser(@RequestBody ArrayList<Integer> listId) {
//        if (!listId.isEmpty ()) {
//            listId.forEach (System.out::println);
//            userInfoService.deleteById (listId);
//        }
//        return "ok";
//    }
}
