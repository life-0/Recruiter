package com.life.Controller;

import com.life.Service.user.UserIdService;
import com.life.Service.user.UserLoginService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
 *@Author life-0
 *@ClassName LoginController
 *@Date 2020/8/19 12:29
 *@Description: 
 TODO           
*/
@Controller
@Api
public class LoginController {
    @Resource
    UserIdService userIdService;
    @Resource
    UserLoginService userLoginService;


    @RequestMapping("/ToLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/user/login")
    public String login(@RequestParam("ID") String ID,
                        @RequestParam("password") String password,
                        Model model, HttpSession session, HttpServletRequest request,
                        HttpServletResponse response) {
        System.out.println ("ID: " + ID);
        System.out.println ("account: " + ID);
        System.out.println ("password: " + password);

        //获取当前用户
        Subject subject = SecurityUtils.getSubject ();
        //封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken (ID, password);

     /*   //提前将共享的数据传到浏览器中 身份信息
        List<Identity> identities = identityService.queryAll ();
        for (Identity identity : identities) {
            Cookie cookie = new Cookie (identity.getId (), identity.getName ());
            cookie.setPath ("/");
            response.addCookie (cookie);
        }*/


        try {
            subject.login (token);  //执行登录方法,如果没有异常就ok
            String rememberMe = request.getParameter ("RememberMe");    //获得参数
            session.setAttribute ("loginSession", ID);
//            System.out.println ("rememberMe=>"+rememberMe);  //记住我被勾选则是on 否则null
            if (rememberMe != null) {
                token.setRememberMe (true);
            }
            return "index";
        } catch (UnknownAccountException uae) {  //用户名不存在
            model.addAttribute ("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException ice) {   //密码错误
            model.addAttribute ("msg", "密码错误");
            return "login";
        }

    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.removeAttribute ("loginSession");
        session.invalidate ();
        System.out.println ("loginSession:" + session.getAttribute ("loginSession"));
        return "redirect:/user/login";
    }
}
