package com.life.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/*
 *@Author life-0
 *@ClassName SwaggerConfig
 *@Date 2020/9/3 13:56
 *@Description: 
 TODO           
*/
@Configuration
@EnableSwagger2 //开启swagger
public class SwaggerConfig {


    //Api分组
    @Bean
    public Docket docket1(){
        return new Docket (DocumentationType.SWAGGER_2)
                .groupName ("life_1")
                ;
    }

    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的Swagger环境
        Profiles profiles=Profiles.of ("dev","test");
        // 通过environment.acceptsProfiles判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles (profiles);
        return new Docket (DocumentationType.SWAGGER_2)
                .apiInfo (apiInfo())
                .groupName ("life")
                .enable (true)  //enable是否启动Swagger, 如果为false 则Swagger不能在浏览器中访问
                .select ()
                /*
                 * RequestHandlerSelectors, 配置要扫描接口的方式
                 * basePackage: 指定要扫描的包
                 * any(): 扫描全部
                 * none(): 不扫描
                 * withClassAnnotation (): 扫描类上的注解, 参数是一个注解的反射现象
                 * withMethodAnnotation(): 扫描方法上的注解
                 * */
                .apis (RequestHandlerSelectors.basePackage ("com.life.Controller"))//扫描包的路径
                //paths() 过滤什么路径
                // .paths (PathSelectors.ant ("/life/**"))
                .build ()
                ;
    }

    //配置Swagger信息的=apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact =  new Contact("life",
                "http://localhost:9090/swagger-ui.html",
                "1471925853@qq.com");
        return new ApiInfo(
                "life的SwaggerAPI文档",
                "Api Documentation",
                "1.0",
                "http://localhost:9090/swagger-ui.html",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<> ());

    }

}
