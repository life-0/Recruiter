package com.life.Controller;

import com.life.POJO.Identity;
import com.life.Service.IdentityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
 *@Author life-0
 *@ClassName IndexController
 *@Date 2020/8/18 11:32
 *@Description: 
 TODO           
*/
@Controller
public class IndexController {
    @Resource
    IdentityService identityService;
    @RequestMapping({"/","index.html"})
    public String index(HttpServletResponse response){
        List<Identity> identities = identityService.queryAll ();

        return "index";
    }
    @RequestMapping("/interface")
    public String Interface(){
        return "interface/ajax_test";
    }

    @RequestMapping({"/404", "404.html"})
    public String test404() {
        return "error/404";
    }

    @RequestMapping({"/blank", "blank.html"})
    public String blank() {
        return "blank";
    }

    @RequestMapping({"/buttons", "buttons.html"})
    public String buttons() {
        return "buttons";
    }

    @RequestMapping({"/cards", "cards.html"})
    public String cards() {
        return "cards";
    }

    @RequestMapping({"/charts", "charts.html"})
    public String charts() {
        return "charts";
    }

    @RequestMapping({"/forget", "forgot-password.html"})
    public String forget() {
        return "forgot-password";
    }

    @RequestMapping({"/login", "login.html"})
    public String login() {
        return "login";
    }

    @RequestMapping({"/register", "register.html"})
    public String register() {
        return "register";
    }

    /*@RequestMapping({"/tables", "tables.html"})
    public String tables() {
        return "tables";
    }*/

    @RequestMapping({"/utilities-animation", "utilities-animation.html"})
    public String Utilities_animation() {
        return "utilities-animation";
    }

    @RequestMapping({"/utilities-border", "utilities-border.html"})
    public String Utilities_border() {
        return "utilities-border";
    }

    @RequestMapping({"/utilities-color", "utilities-color.html"})
    public String Utilities_color() {
        return "utilities-color";
    }

    @RequestMapping({"/utilities-other", "utilities-other.html"})
    public String Utilities_other() {
        return "utilities-other";
    }

}
