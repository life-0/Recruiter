package com.life;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.life.Mapper")
@EnableScheduling
public class Springboot04WebprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run (Springboot04WebprojectApplication.class, args);
    }
    /*
    * 实现角色 用户 权限分配表  2张关系表
    * 实现两种关系的连接
    *
    */
}
