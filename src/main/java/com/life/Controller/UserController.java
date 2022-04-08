package com.life.Controller;


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
import java.util.*;

/*
 *@Author life-0
 *@ClassName StudentController
 *@Date 2020/9/24 10:00
 *@Description: 
 TODO           用户管理
*/
@Controller
@Api(tags = "用户测试类")
@RequestMapping("/user")
public class UserController {
    @Resource
    UserInfoServiceImpl userInfoService;

    @ApiOperation("展示所有的用户")
    @GetMapping({"/tables"})
    @ResponseBody
    public Result<?> UserTable(Model model) {
        List<UserInfo> users = userInfoService.queryAll ();
        model.addAttribute ("users", users);
//        return "/employee/tables";

        return Result.ok (users);
    }

//    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
//    @ResponseBody
//    public String update(@RequestBody Map<String, Object> map) {
//
//        for (Map.Entry<String, Object> next : map.entrySet ()) {
//            String key = next.getKey ();
//            String value = (String) next.getValue ();
//            System.out.println (key + " :" + value);
//        }
//        return "ok";
//    }
//
//    @RequestMapping(value = {"/toAdd"}, method = RequestMethod.POST)
//    @ResponseBody
//    public String ToAdd(@RequestBody UserInfo userInfo) throws JSONException {
//        // Map<String , Object> map
//        NumberUtil number = new NumberUtil ();
//        System.out.println (userInfo.toString ());
////        userInfoService.insert (userInfo);
//        return "ok";
//    }
//
//    @ApiImplicitParams({    //参数描述
//            @ApiImplicitParam(name = "listId",
//                    value = "按照用户ID数组删除",
//                    required = true,
//                    paramType = "query",
//                    allowMultiple = true,
//                    dataType = "int")})
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "数据正确"),
//            @ApiResponse(code = 400, message = "参数不符合"),
//            @ApiResponse(code = 404, message = "请求路径不对"),
//            @ApiResponse(code = 408, message = "业务报错,返回客户端")
//    })
//    @ApiOperation("删除用户")
//    @RequestMapping(value = "/deleteStu", method = RequestMethod.DELETE)
//    @ResponseBody
//    public String deleteUser(@RequestBody ArrayList<Integer> listId) {
//        if (!listId.isEmpty ()) {
//            listId.forEach (System.out::println);
//            userInfoService.deleteById (listId);
//        }
//        return "ok";
//
//    }
/*
    @ApiOperation("添加用户")
    @RequestMapping({"/Add"})
    public String AddUser(@RequestParam("") String Name, Model model) {
        String number = new NumberUtil ().getRandomNumber ();   //临时参数 二次使用
        UserInfo user = new UserInfo (null, number,
                permission, null, password, Email, Name, new Date (),
                iphone, "");
        int i = userService.insert (user);
        User userID = userService.selectByPrimaryKey (null, number);    //使用上参数获得id
        userID.setRole_ID (role);
        userService.updateByPrimaryKey (userID);
//        System.out.println (userID.toString ());
        UserRole userRole = new UserRole (userID.getId (), role, new NumberUtil ().getRandomNumber ());
        userRoleService.insert (userRole);//添加进User_Role表

        if (i == 1) {
            model.addAttribute ("message", "数据添加成功");
        } else {
            model.addAttribute ("message", "数据添加失败");
        }
        return "redirect:/student/tables";
    }

    @ApiOperation("删除用户")
    @RequestMapping("/DeleteStu")
    @ResponseBody
    public String DeleteStudent(@RequestParam ArrayList<Integer> data) {
        int result_y = 0;
        int result_x = 0;
        for (Integer s : data) {
            System.out.println (s);
            result_y = userRoleService.deleteByUser_ID (s);
            result_x = userService.deleteByPrimaryKey (s, null);
        }
        if (result_x == 1 && result_y == 1) //简单判断程序是否执行成功
            return "ok";
        else {
            return "error";
        }
    }

    @RequestMapping("/ToUpdate/{ID}")
    public String ToUpdate(@PathVariable(name = "ID") int ID, Model model) {
        User user = userService.queryUserByID (ID);
        model.addAttribute ("user", user);
        return "/employee/Update";
    }

    @ApiOperation("修改用户")
    @RequestMapping("/Update")
    @ResponseBody
    public String UpdateStudent(@RequestBody User user, HttpServletResponse response) {
        System.out.println (user.toString ());
        int i = userService.updateByPrimaryKeySelective (user);
        int j = 0;
        List<UserRole> userRoles = userRoleService.selectAllByUserId (user.getId ());
        for (UserRole userRole : userRoles) {
            userRole.setIdentityId (user.getRole_ID ());
            j = userRoleService.updateByPrimaryKey (userRole);
        }
        System.out.println ("i=> " + i + "\n" + "j=>" + j);
        Cookie cookie;//设置返回消息
        if (i == 1) {
            cookie = new Cookie ("content", "修改成功");
        } else {
            cookie = new Cookie ("content", "修改失败");
        }
        cookie.setPath ("/student/tables");
        cookie.setMaxAge (10);  //设置cookie存活时间
        response.addCookie (cookie);
        return "ok";
    }

    @ApiImplicitParams({    //参数描述
            @ApiImplicitParam(name = "ID",
                    value = "按照用户ID,姓名等进行查询",
                    required = true,
                    paramType = "query")})
    @ApiResponses({
            @ApiResponse(code = 400, message = "参数不符合"),
            @ApiResponse(code = 404, message = "请求路径不对"),
            @ApiResponse(code = 408, message = "业务报错,返回客户端")
    })
    @ApiOperation("查询测试")
    @PostMapping("/query")
    @ResponseBody
    public User queryByID(@RequestParam("ID") Integer ID) {
        return userService.queryUserByID (ID.intValue ());
    }*/
}
