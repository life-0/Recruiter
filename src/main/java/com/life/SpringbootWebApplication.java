package com.life;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.life.Mapper")
@EnableScheduling

@EnableKnife4j
@ServletComponentScan
public class SpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run (SpringbootWebApplication.class, args);
    }
    /*
     *
     * 做一个招聘网站
     * 关系: 用户,权限,角色
     * 业务: 用户增删改查
     * 资源: 公司创建的职位, 过期资源(过时的职位), 求职者的简历, 求职者的个人信息,诉求
     * 行业: 医疗,计算机,土木,农业
     * 未来拓展: 按照地域(第一优先级),职业进行推送职位
     */
}
