package com.life.Config;

import com.life.Utils.redisUtil;
import com.life.Utils.tokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Security;
import java.util.Objects;

/*
 *@Author life-0
 *@ClassName AddHandleInterceptor
 *@Date 2022/4/02 20:23
 *@Description: 添加拦截
 * TODO 添加redis注入的时候必须要注意spring注入的优先级!  https://blog.csdn.net/weixin_41326813/article/details/108527194
 */
@Slf4j
@Component
public class MyHandleInterceptor implements HandlerInterceptor {
    @Autowired
    private redisUtil redisImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response,
                             @NotNull Object handler) throws Exception {
        System.out.println ("preHandle....");
        String uri = request.getRequestURI ();
        System.out.println ("当前路径: " + uri);
        String pattern = "";
        //略过登录接口
        if (Objects.equals (uri, "/gate/login")) {
            return true;
        }
        /**
         * HandlerMethod=>Controller中标注@RequestMapping的方法
         *  需要配置静态资源不拦截时，添加这块逻辑  => 前后端分离项目
         */
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //权限认证
/*        String token = request.getHeader ("BASE_TOKEN");
        if (token != null ) {
            if (redisImpl.isExpire (token)){
                // 未登录跳转到登录界面
                return true;
            }else {
                log.info ("BASE_TOKEN is null");
                request.getRequestDispatcher ("/gate/login").forward (request, response);
                return false;
            }
        } else {
            return false;
        }*/
        return true;
    }

    //Controller逻辑执行完毕但是视图解析器还未进行解析之前
    @Override
    public void postHandle(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println ("postHandle....");
    }

    //Controller逻辑和视图解析器执行完毕
    @Override
    public void afterCompletion(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println ("afterCompletion....");
    }


}
