package com.life.POJO.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*
 *@Author: life-0
 *@ClassName: UserMessageListener
 *@Date: 2022/4/22 23:47
 *TODO @Description:

 */
@Slf4j
@Component
public class UserMessageListener {
    public static final String TOPIC_NAME = "jaemon:user:*";

    public void receiveMessage(String message) {
        log.info("用户事件: message=[{}]", message);
    }
}