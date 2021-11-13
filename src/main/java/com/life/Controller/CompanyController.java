package com.life.Controller;

import com.life.POJO.User;
import com.life.Service.RoleService.AdminService;
import com.life.Service.UserServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
 *@Author life-0
 *@ClassName CompanyController
 *@Date 2020/10/10 10:21
 *@Description:
 TODO           
*/
@Controller
@Api
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/tables")
    public String CompanyTable(Model model){
        List<User> users = userService.showAll ();
        model.addAttribute ("users", users);
        return "/Company/table";
    }
    @RequestMapping("/firmTemplate")
    public  String CompanyTemplate(){
        return "/Company/firm-inputFrame-template";
    }
}
