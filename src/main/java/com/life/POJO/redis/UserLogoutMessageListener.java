package com.life.POJO.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*
 *@Author: life-0
 *@ClassName: UserLogoutMessageListener
 *@Date: 2022/4/22 23:46
 *TODO @Description:

 */
@Slf4j
@Component
public class UserLogoutMessageListener {
    public static final String TOPIC_NAME = "jaemon:user:logout";

    public void handleMessage(String message) {
        log.info("用户注销事件: message=[{}]", message);
    }

}