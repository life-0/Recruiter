package com.life.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/*
 *@Author life-0
 *@ClassName DruidConfig
 *@Date 2020/8/26 12:50
 *@Description: 
 TODO           
*/
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource DruidSource() {
        return new DruidDataSource ();
    }

    //后台监控:相当于web.xml
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>
                (new StatViewServlet (), "/druid/*"); // 现在要进行druid监控的配置处理操作);
        //后台需要人登录,账号密码配置
        HashMap<String, String> initParameters = new HashMap<> ();
        //增加配置
        initParameters.put ("loginUsername", "admin");//登录key 是指定的,
        initParameters.put ("loginPassword", "333");

        //允许谁可以进行访问
        initParameters.put ("allow", "");
        //禁止谁访问
        //initParameters.put ("life","192.168.11.123");
        bean.setInitParameters (initParameters);
        return bean;

    }

}
