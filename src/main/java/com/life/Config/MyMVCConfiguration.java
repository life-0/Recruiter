package com.life.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    //视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController ("/").setViewName ("index");
        registry.addViewController ("/index.html").setViewName ("index");
        registry.addViewController ("/index").setViewName ("index");
    }

    //自定义国际化组件生效
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver ();
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor (new LoginHandleInterceptor ()).addPathPatterns ("/**")
                .excludePathPatterns ("/login.html","/login","/index.html","/user/login","/css/**"
                        ,"/img/**","/js/**","/scss/**","/vendor/**");
    }
}
