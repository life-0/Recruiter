package com.life.Controller;

import com.life.POJO.test.Student;
import com.life.Service.RoleService.StudentService;
import com.life.Utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    StudentService service;

    @RequestMapping({"/tables", "tables.html"})
    public String StudentTables(Model model) {
        List<Student> students = service.studentList ();
        model.addAttribute ("students", students);
        return "/employee/tables";
    }

    @RequestMapping({"/ToAdd"})
    public String ToAdd() {
        return "/employee/AddPage";
    }

    @RequestMapping({"/Add"})
    public String AddStudent(@RequestParam(name = "ID") String ID,
                             @RequestParam(name = "Name") String Name,
                             @RequestParam(name = "Email") String Email,
                             @RequestParam(name = "sex") char sex,
                             @RequestParam(name = "Account") String Account,
                             @RequestParam(name = "password") String password,
                             Model model) {

        Student student = new Student (ID, sex, Name, Email, "", "",
                password, Account, new NumberUtil ().getRandomNumber (), "");
        int i = service.AddStudent (student);
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
    public String ToUpdate(@PathVariable("ID") String ID, Model model) {
        Student student = service.getStudent (ID);
        model.addAttribute ("student", student);
        return "/employee/Update";
    }

    @PostMapping("/Update")
    public String UpdateStudent(Student student) {
        int i = service.UpdStudent (student);
        return "redirect:/student/tables";
    }
}
