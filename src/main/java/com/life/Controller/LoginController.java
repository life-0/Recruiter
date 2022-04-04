package com.life.Controller;

import com.life.POJO.user.UserLogin;
import com.life.Utils.tokenUtil;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
 *@Author life-0
 *@ClassName LoginController
 *@Date 2020/8/19 12:29
 *@Description: 
 TODO           
*/
@Controller
@Api("登录登出")
public class LoginController {
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @ResponseBody
    @PostMapping(value = "/user/login")
//    @RequestBody UserLogin userLogin,
    public Result<?> login(@RequestParam("account") String account,
                           @RequestParam("password") String password,
                           HttpServletRequest request) {
        //封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken (account,password);

        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject ();
        try {
            currentUser.login (token);  //执行登录方法,如果没有异常就ok
            //从session中获取用户信息
            UserLogin user = (UserLogin) currentUser.getPrincipal ();
            String rememberMe = request.getParameter ("RememberMe");    //获得参数

            //自定义存储
            Map<String, Object> map = new HashMap<> ();
            String tokenNumber = tokenUtil.generateToken (user);
            map.put ("data", user);
            map.put ("token", tokenNumber);
            if (user == null) {
                throw new AuthenticationException ();
            }
            if (rememberMe != null) {
                token.setRememberMe (true);
            }
            return Result.OK (map);
        } catch (Exception e) {
            return Result.error ("erro");
        }

//            return "index";
//        } catch (UnknownAccountException uae) {  //用户名不存在
//            model.addAttribute ("msg", "用户名不存在");
//            return "login";
//        } catch (IncorrectCredentialsException ice) {   //密码错误
//            model.addAttribute ("msg", "密码错误");
//            return "login";
//        } catch (LockedAccountException lae) {
//            model.addAttribute ("msg", "账号被锁定");
//            return "login";
//        } catch (AuthenticationException ae) {
//            model.addAttribute ("msg", "登录出错");
//            return "login";
//        }

    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject ();
        subject.logout ();
        return "redirect:/toLogin";
    }
}
