package com.life.Config;

import com.life.Utils.tokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Security;

/*
 *@Author life-0
 *@ClassName AddHandleInterceptor
 *@Date 2022/4/02 20:23
 *@Description: 添加拦截
 TODO
*/
@Slf4j
public class MyHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
      /*  Subject subject = SecurityUtils.getSubject ();
        subject.getSession ();
        //登陆成功后,应该会有自己的session
        Object loginSession = request.getSession ().getAttribute ("loginSession");
        if (loginSession == null) {
            request.setAttribute ("msg", "无权限,请先登录");
            request.getRequestDispatcher ("/login.html").forward (request, response);
            return false;
        } else {
            return true;
        }*/
        System.out.println("preHandle....");
        String uri = request.getRequestURI();
        System.out.println("当前路径: "+uri);

        /**
         * HandlerMethod=>Controller中标注@RequestMapping的方法
         *  需要配置静态资源不拦截时，添加这块逻辑  => 前后端分离项目
         */
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token=request.getHeader("qcby-token");

        if (!tokenUtil.verify(token)) {
            // 未登录跳转到登录界面
            log.info ("未获得token");
           request.getRequestDispatcher ("/user/login").forward (request,response);
           return false;
        } else {
            return true;
        }
    }

    //Controller逻辑执行完毕但是视图解析器还未进行解析之前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle....");
    }

    //Controller逻辑和视图解析器执行完毕
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion....");
    }


}
