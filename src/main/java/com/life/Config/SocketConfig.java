package com.life.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/*
 *@Author: life-0
 *@ClassName: SocketConfig
 *@Date: 2022/4/13 19:48
 *TODO @Description: WebSocket配置类

 */

@Configuration
@EnableWebSocket
public class SocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter ();
    }
}