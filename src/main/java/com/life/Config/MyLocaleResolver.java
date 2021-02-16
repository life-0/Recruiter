package com.life.Config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/*
 *@Author life-0
 *@ClassName MyLocaleResolver
 *@Date 2020/8/19 12:08
 *@Description: 
 TODO           
*/
public class MyLocaleResolver implements LocaleResolver {
    //请求解析
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获得请求中的语言参数
        String language = httpServletRequest.getParameter ("l");
        Locale locale=Locale.getDefault ();  //如果没有则使用默认的
        //如果请求的链接中携带了国际化的参数
        if(!StringUtils.isEmpty (language)){
            //zh_CN
            String[] split = language.split ("_");
            //国家,地区
            locale = new Locale (split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
