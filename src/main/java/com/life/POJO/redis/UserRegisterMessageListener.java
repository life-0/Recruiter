package com.life.POJO.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*
 *@Author: life-0
 *@ClassName: UserRegisterMessageListener
 *@Date: 2022/4/22 23:42
 *TODO @Description:

 */
@Slf4j
@Component
public class UserRegisterMessageListener {
    public static final String TOPIC_NAME = "jaemon:user:register";

    public void handleMessage(String message) {
        log.info("用户注册事件: message=[{}]", message);
    }

}