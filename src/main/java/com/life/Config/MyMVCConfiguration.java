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
        registry.addInterceptor (new LoginHandleInterceptor ())
                .addPathPatterns ("/**")
                .excludePathPatterns ("/login.html", "/login", "/index.html", "/user/login",
                        "/css/**", "/img/**", "/static/js/**", "/scss/**", "/vendor/**")
                .excludePathPatterns ( "/docs.html","/swagger-resources/**",
                        "/webjars/**", "/v2/**", "/docs.html/**")
                .excludePathPatterns ("/swagger-ui.html")
        ;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler ("/static/**").addResourceLocations ("classpath:/static/");
        registry.addResourceHandler ("/templates/**").addResourceLocations ("classpath:/templates/");
        // 放行swagger
        registry.addResourceHandler ("/docs.html").addResourceLocations ("classpath:/META-INF/resources/");
        registry.addResourceHandler ("/webjars/**").addResourceLocations ("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler ("/v2/**").addResourceLocations ("classpath:/META-INF/resources/v2/");
    }

}
