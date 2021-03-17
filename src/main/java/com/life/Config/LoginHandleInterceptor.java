package com.life.Config;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 *@Author life-0
 *@ClassName LoginHandleInterceptor
 *@Date 2020/8/20 10:23
 *@Description: 
 TODO           
*/
public class LoginHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //过滤路径中带 ;jsessionid=003EC21DCDFA5169409DB58EE39C0896 的问题
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession ();
        if (requestURI.contains (";jsessionid=")) {
            //替换掉路径上的内容, ;jsessionid=003EC21DCDFA5169409DB58EE39C0896
            requestURI = requestURI.replace(";jsessionid=" + session.getId(),"");
            //重定向一下
            request.getRequestDispatcher(requestURI).forward(request, response);
            return false;
        }

        //登陆成功后,应该会有自己的session
        Object loginSession = request.getSession ().getAttribute ("loginSession");
        if (loginSession==null){
            request.setAttribute ("msg","无权限,请先登录");
            request.getRequestDispatcher ("/login.html").forward (request,response);
            return false;
        }else {
            return true;
        }
    }
}
