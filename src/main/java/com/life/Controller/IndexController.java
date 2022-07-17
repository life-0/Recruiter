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
}
