package com.life.Config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/*
 *@Author life-0
 *@ClassName ShiroConfig
 *@Date 2020/8/30 11:42
 *@Description: 
 TODO           
*/

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean    第三步
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBear(@Qualifier("SecurityManager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean ();
        //设置安全管理器
        bean.setSecurityManager (manager);

        //添加shiro的内置过滤器
        /*
            anon:   无需认证就可以访问
            authc:  必须认证了才能访问
            user:   必须拥有"记住我" 这个功能才能访问
            perms:  拥有对某个资源的权限才能访问
            role:   拥有某个角色权限才能访问
        */

        //拦截
        LinkedHashMap<String,String> filterMap = new LinkedHashMap<> ();
        //以下是controller定义的拦截路径, 因为页面访问的是controller的路径这边就写同样的路径即可
//        filterMap.put ("/student/*","perms[user:table]");   //user:stu 设置相当于权限令牌
//        filterMap.put ("/charts","perms[user:company]");
        filterMap.put ("/student/*","perms[stu:true]");
        filterMap.put ("/charts","perms[com:true]");
        filterMap.put ("login.html","anon");

        //设置登出
        filterMap.put ("/logout","logout");

    //  filterMap.put ("/user/*","authc");  //支持通配符
        bean.setFilterChainDefinitionMap (filterMap);
        //设置未认证页面
        bean.setUnauthorizedUrl ("/404");
        //设置登录的请求
        bean.setLoginUrl ("/ToLogin");
//        bean.setSuccessUrl ("/index");
        return bean;
    }
    //DefaultWebSecurityManager     第二步
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager ();
        //关联UserRealm
        securityManager.setRealm (userRealm);
        return securityManager;
    }

    //创建Realm对象 自定义类    第一步
    @Bean
    public UserRealm userRealm(){
        return new UserRealm ();
    }

    //整合ShiroDialect    用来整合 shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect ();
    }
}
