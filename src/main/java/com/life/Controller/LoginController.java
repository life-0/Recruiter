package com.life.Controller;

import com.life.POJO.user.UserLogin;
import com.life.Utils.redisUtil;
import com.life.Utils.tokenUtil;
import com.life.api.vo.Result;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Autowired
    private redisUtil redisImpl;

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
        UsernamePasswordToken token = new UsernamePasswordToken (account, password);

        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject ();
        try {
            currentUser.login (token);  //执行登录方法,如果没有异常就ok
            //从session中获取用户信息
            UserLogin user = (UserLogin) currentUser.getPrincipal ();
            String rememberMe = request.getParameter ("RememberMe");    //获得参数

            //自定义存储
            Map<String, Object> map = new HashMap<> ();
            String tokenNumber = tokenUtil.generateToken (user);//生成给客户端的令牌
            //存放进redis中
            redisImpl.set (tokenNumber, user);   //修改为存放在redis中
            redisImpl.expire (tokenNumber, 60 * 60 * 2);    //设置失效时间为2个小时

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
            return Result.error ("error333");
        }
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject ();
        subject.logout ();
        return "redirect:/toLogin";
    }
}
