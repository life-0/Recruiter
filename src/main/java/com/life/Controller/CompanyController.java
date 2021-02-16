package com.life.Controller;

import com.life.Service.RoleService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *@Author life-0
 *@ClassName CompanyController
 *@Date 2020/10/10 10:21
 *@Description: 
 TODO           
*/
@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    AdminService service;

    @RequestMapping("/tables")
    public String CompanyTable(Model model){
        return "/Company/table";
    }
}
