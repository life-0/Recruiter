package com.life.Controller;

import com.life.POJO.User;
import com.life.POJO.UserRole;
import com.life.POJO.test.Student;
import com.life.Service.RoleService.StudentService;
import com.life.Service.RoleService.StudentServiceImpl;
import com.life.Service.UserRoleServiceImpl;
import com.life.Service.UserServiceImpl;
import com.life.Utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Time;
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


    @RequestMapping({"/tables", "tables.html"})
    public String UserTable(Model model) {
//        List<Student> students = service.studentList ();
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
        String number = new NumberUtil ().getRandomNumber ();
        User user = new User (null, number,
                permission, null, password, Email, Name, new Date (),
                iphone, "");

        int i = userService.insert (user);
        User userID = userService.selectByPrimaryKey (null, number);
        UserRole userRole = new UserRole (userID.getId (), role, new NumberUtil ().getRandomNumber ());
        userRoleService.insert (userRole);
        System.out.println (user.toString ());

        if (i == 1) {
            model.addAttribute ("message", "数据添加成功");
        } else {
            model.addAttribute ("message", "数据添加失败");
        }
        return "redirect:/student/tables";
    }

    @RequestMapping("/DeleteStu")
    @ResponseBody
    public String DeleteStudent(@RequestParam List<String> data) {
        for (String s : data) {
            System.out.println (s);
        }

        return "redirect:/student/tables";
    }

    @RequestMapping("/ToUpdate/{ID}")
    public String ToUpdate(@PathVariable("ID") int ID, Model model) {
        User user = userService.queryUserByID (ID);
        model.addAttribute ("user", user);
        return "/employee/Update";
    }

    @PostMapping("/Update")
    public String UpdateStudent(User user) {

        int i = userService.updateByPrimaryKeySelective (user);
        return "redirect:/student/tables";
    }
}
