package com.life.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;
import java.util.Locale;

/*
 *@Author life-0
 *@ClassName MyMVCConfiguration
 *@Date 2020/8/18 11:29
 *@Description: 
 TODO           
*/
@Configuration
public class MyMVCConfiguration implements WebMvcConfigurer {
    @Bean
    public MyHandleInterceptor getInterceptor(){
        return new MyHandleInterceptor ();
    }

    //视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController ("/").setViewName ("index");
        registry.addViewController ("/index.html").setViewName ("index");
        registry.addViewController ("/index").setViewName ("index");

    }


    //自定义国际化组件生效
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver ();
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor (getInterceptor ())
                .addPathPatterns ("/**")    // 拦截所有页面  前提是shiro不能设置 filterMap.put ("/*", "authc");
                .excludePathPatterns ("/login.html", "/login", "/index.html", "/toLogin", "/user/login",
                        "/favicon.ico","/error")//除去这些
                // 开放knife4j
                .excludePathPatterns ("/doc.html", "/service-worker.js", "/swagger-resources");    //除去knife4j的所有链接
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置拦截器访问静态资源
        registry.addResourceHandler ("/static/**").addResourceLocations ("classpath:/static/");
        registry.addResourceHandler ("/templates/**").addResourceLocations ("classpath:/templates/");
    }

}
