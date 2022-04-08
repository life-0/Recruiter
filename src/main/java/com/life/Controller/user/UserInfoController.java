package com.life.Controller.user;

import com.life.Mapper.user.UserInfoMapper;
import com.life.POJO.user.UserInfo;
import com.life.Service.user.UserInfoServiceImpl;
import com.life.Utils.NumberUtil;
import com.life.api.vo.Result;
import io.swagger.annotations.*;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    @PostMapping("/getUserInfo")
    public Result<?> getUserInfo(@RequestParam(value = "id", required = false) String id) {
        List<UserInfo> users = null;
        if (id != null) {
            users.add (userInfoService.selectById (id));
        }else {
           users = userInfoService.queryAll ();
        }
        return Result.ok (users);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody Map<String, Object> map) {

        for (Map.Entry<String, Object> next : map.entrySet ()) {
            String key = next.getKey ();
            String value = (String) next.getValue ();
            System.out.println (key + " :" + value);
        }
        return "ok";
    }

    @RequestMapping(value = {"/toAdd"}, method = RequestMethod.POST)
    public String ToAdd(@RequestBody UserInfo userInfo) throws JSONException {
        // Map<String , Object> map
        NumberUtil number = new NumberUtil ();
        System.out.println (userInfo.toString ());
//        userInfoService.insert (userInfo);
        return "ok";
    }

    @ApiImplicitParams({    //参数描述
            @ApiImplicitParam(name = "listId",
                    value = "按照用户ID数组删除",
                    required = true,
                    paramType = "query",
                    allowMultiple = true,
                    dataType = "int")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "数据正确"),
            @ApiResponse(code = 400, message = "参数不符合"),
            @ApiResponse(code = 404, message = "请求路径不对"),
            @ApiResponse(code = 408, message = "业务报错,返回客户端")
    })
    @ApiOperation("删除用户")
    @RequestMapping(value = "/deleteStu", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@RequestBody ArrayList<Integer> listId) {
        if (!listId.isEmpty ()) {
            listId.forEach (System.out::println);
            userInfoService.deleteById (listId);
        }
        return "ok";
    }
}
