package com.life.websocket.net;

import com.alibaba.fastjson.JSON;
import com.life.POJO.websocket.socketMsg;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/*
 *@Author: life-0
 *@ClassName: WebSocketCustomEncoding
 *@Date: 2022/4/17 15:12
 *TODO @Description:

 */
public class WebSocketCustomEncoding implements Encoder.Text<socketMsg> {
    @Override
    public String encode(socketMsg msg) {
        assert msg != null;
        System.out.println (JSON.toJSONString (msg));
        return JSON.toJSONString (msg);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}

