package com.life.Controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/*
 *@Author life-0
 *@ClassName IndexController
 *@Date 2020/8/18 11:32
 *@Description: 
 TODO      初始启动后台网页
*/
@Controller
@Api
public class IndexController {
    @GetMapping({"/", "index.html"})
    public String index(HttpServletResponse response) {
        return "index";
    }

    @GetMapping("/interface")
    public String Interface() {
        return "interface/ajax_test";
    }

    @GetMapping({"/404", "404.html"})
    public String test404() {
        return "error/404";
    }

    @GetMapping({"/blank", "blank.html"})
    public String blank() {
        return "blank";
    }

    @GetMapping({"/buttons", "buttons.html"})
    public String buttons() {
        return "buttons";
    }

    @GetMapping({"/cards", "cards.html"})
    public String cards() {
        return "cards";
    }

    @GetMapping({"/charts", "charts.html"})
    public String charts() {
        return "charts";
    }

    @GetMapping({"/forget", "forgot-password.html"})
    public String forget() {
        return "forgot-password";
    }

    @GetMapping({"/login", "login.html"})
    public String login() {
        return "login";
    }

    @GetMapping({"/register", "register.html"})
    public String register() {
        return "register";
    }

    /*@GetMapping({"/tables", "tables.html"})
    public String tables() {
        return "tables";
    }*/

    @GetMapping({"/utilities-animation", "utilities-animation.html"})
    public String Utilities_animation() {
        return "utilities-animation";
    }

    @GetMapping({"/utilities-border", "utilities-border.html"})
    public String Utilities_border() {
        return "utilities-border";
    }

    @GetMapping({"/utilities-color", "utilities-color.html"})
    public String Utilities_color() {
        return "utilities-color";
    }

    @GetMapping({"/utilities-other", "utilities-other.html"})
    public String Utilities_other() {
        return "utilities-other";
    }

}
