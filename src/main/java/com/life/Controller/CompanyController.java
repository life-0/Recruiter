package com.life.Controller;

import com.life.Service.user.UserInfoServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
//    @Resource
//    private UserInfoServiceImpl userInfoService;

    //    @RequestMapping(value = "/tables",method = RequestMethod.POST)
//    public String CompanyTable(Model model) {
//        List<UserInfo> users = userInfoService.showAll ();
//        model.addAttribute ("users", users);
//        return "/Company/table";
//    }
    @RequestMapping("/toUpdate")
    public String toUpdate() {

        return "";
    }

    @GetMapping("/firmTemplate")
    public String CompanyTemplate() {
        return "/Company/firm-inputFrame-template";
    }
}
