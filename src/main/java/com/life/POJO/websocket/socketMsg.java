package com.life.POJO.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class socketMsg {
    private String msg;        // 消息内容
    private String sendUserId;   // 发送消息方
    private String acceptUserId; // 接受消息方
    private String sendType;   // 发送类型：0私聊；1群聊
    private String msgType;    // 内容类型：0文本；1图片
    private Long currentTime;   //当前事件
}
