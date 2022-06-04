package com.life.Config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import com.life.Utils.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/*
 *@Author: life-0
 *@ClassName: MyBatisMetaObjectHandler
 *@Date: 2022/4/24 9:13
 *TODO @Description:    mybatis 自动填充配置
 *  填充处理器 MyMetaObjectHandler 在 Spring Boot 中需要声明 @Component 或 @Bean 注入
    strictInsertFill 和 strictUpdateFill 方法第二个参数写的是实体类里的属性名，不是对应数据库字段名。
 */
@Slf4j
@Component
@EnableMPP  //开启MPP,支持联合主键
public class MyBatisMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info ("start insert fill ....");
        this.strictInsertFill (metaObject, "number", String.class, NumberUtil.getRandomNumber ());
//        this.strictInsertFill (metaObject,"id",Integer.class,)
        this.strictInsertFill (metaObject, "createTime", Date.class, new Date ());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info ("start update fill ....");
        this.strictUpdateFill (metaObject, "updateTime", Date.class, new Date ());
    }
}
