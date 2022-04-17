package com.life.websocket.net;

import com.life.POJO.websocket.socketMsg;
import com.life.api.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.EncodeException;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;

import static com.life.websocket.net.socketPool.sessionPool;

/*
 *@Author: life-0
 *@ClassName: socketAction
 *@Date: 2022/4/15 10:06
 *TODO @Description:

 */
public class socketAction {

    private static final Logger log = LoggerFactory.getLogger (socketAction.class);


    /**
     * 实现服务器主动推送私人信息
     *
     * @param session session
     * @param msg     发送的消息
     */
    public void sendMessage(Session session, socketMsg msg) {
        // 判断session是否为空
        if (session == null)
            return;
        //获得目标用户session值,以阻塞形式(Basic)发送
        final RemoteEndpoint.Basic basic = session.getBasicRemote ();
        if (basic == null)
            return;
        try {
            // 给用户发送消息
            basic.sendObject (msg);
        } catch (IOException e) {
            log.error ("消息发送异常，异常情况: {}", e.getMessage ());
        } catch (EncodeException e) {
            throw new RuntimeException (e);
        }
    }

    /**
     * 实现服务器主动推送给所有的在线用户消息
     *
     * @param message  发送的消息
     * @param username 发送者
     */
    public void sendMessageAll(socketMsg message, String username) {
        log.info ("广播：群发消息");
        // 遍历map，只输出给其他客户端，不给自己重复输出
        sessionPool ().forEach ((key, session) -> {
            // 给除了自己以外的所有用户群发消息
            if (!username.equals (key)) {
                sendMessage (session, message);
            }
        });
    }
}
