package com.life.Controller;

import com.life.POJO.user.UserInfo;
import com.life.Service.user.UserInfoServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
    @Resource
    UserInfoServiceImpl userInfoService;

    @RequestMapping("/tables")
    public String CompanyTable(Model model) {
        List<UserInfo> users = userInfoService.showAll ();
        model.addAttribute ("users", users);
        return "/Company/table";
    }

    @RequestMapping("/firmTemplate")
    public String CompanyTemplate() {
        return "/Company/firm-inputFrame-template";
    }
}
