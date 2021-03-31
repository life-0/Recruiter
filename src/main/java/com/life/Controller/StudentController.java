package com.life.Controller;

import com.life.POJO.User;
import com.life.POJO.UserRole;
import com.life.Service.RoleService.StudentServiceImpl;
import com.life.Service.UserRoleServiceImpl;
import com.life.Service.UserServiceImpl;
import com.life.Utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *@Author life-0
 *@ClassName StudentController
 *@Date 2020/9/24 10:00
 *@Description: 
 TODO           
*/
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    StudentServiceImpl service;
    @Resource
    UserRoleServiceImpl userRoleService;


    @GetMapping({"/tables", "tables.html"})
    public String UserTable(Model model) {
        List<User> users = userService.showAll ();
        model.addAttribute ("users", users);
        return "/employee/tables";
    }

    @RequestMapping({"/ToAdd"})
    public String ToAdd() {
        return "/employee/AddPage";
    }

    @RequestMapping({"/Add"})
    public String AddUser(
            @RequestParam(name = "Name") String Name,
            @RequestParam(name = "Email") String Email,
            @RequestParam(name = "Permission") String permission,
            @RequestParam(name = "Role") String role,
            @RequestParam(name = "Password") String password,
            @RequestParam(name = "Iphone") String iphone,
            Model model) {
        String number = new NumberUtil ().getRandomNumber ();   //临时参数 二次使用
        User user = new User (null, number,
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
}
