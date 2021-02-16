package com.life.Config;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
