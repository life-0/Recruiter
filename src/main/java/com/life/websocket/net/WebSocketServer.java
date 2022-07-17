package com.life.websocket.net;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONException;
import com.life.POJO.websocket.socketMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;

@ServerEndpoint(value = "/websocket/{id}",encoders = WebSocketCustomEncoding.class)
@Component
public class WebSocketServer {

    private static final Logger log = LoggerFactory.getLogger (WebSocketServer.class);
    //导入连接池
    Map<String, Session> sessionPool = socketPool.sessionPool ();

    // 导入websocket操作类
    socketAction socketHandler = new socketAction ();
    /**
     * 接收 userId
     */
    private String userId = "";

    /**
     * 连接建立成功调用的方法
     *
     * @param session 与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @param userId  用户id作为键
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("id") String userId) {
        this.userId = userId;
        if (!sessionPool.containsKey (userId)) {
            sessionPool.put (userId, session);  //添加一个用户
        }
        log.info ("用户 " + userId + " 已进入连接池:" + ",当前在线人数为:" + sessionPool.size ());
//        socketHandler.sendMessage (session, new String ("来自服务端消息: 连接成功！"));
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (sessionPool.containsKey (userId)) {
            sessionPool.remove (this.userId);
            log.info ("用户 " + userId + " 已退出连接池:" + ",当前在线人数为:" + sessionPool.size ());
        }

    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws JSONException {

        log.info ("用户id:" + userId + "发出消息 ,报文:" + message);
        if (StringUtils.hasLength (message)) { //判断字符串是否为空
//            JSONObject jsonObject = new JSONObject ();//转换成json对象
            socketMsg msg = JSON.parseObject (message, socketMsg.class);
            System.out.println (msg.toString ());
//            msg.setAcceptUserId (this.userId);
//            jsonObject.put ("fromUserId", this.userId);
//            String toUserId = jsonObject.getString ("toUserId");
//            if (StringUtils.hasLength (toUserId) && sessionPool.containsKey (toUserId)) {
//                //发送
//                socketHandler.sendMessage (sessionPool.get (toUserId), jsonObject.toString ());
//            } else {
//                log.error ("请求的 userId:" + toUserId + "不在该服务器上");
//            }
            if (StringUtils.hasLength (msg.getAcceptUserId ()) && sessionPool.containsKey (msg.getAcceptUserId ())) {
                //发送
                socketHandler.sendMessage (sessionPool.get (msg.getAcceptUserId ()), msg);
            } else {
                log.error ("接收者userId:" + msg.getAcceptUserId () + " 不在该服务器上");
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error ("用户错误:" + this.userId + ",原因:" + error.getMessage ());
        error.printStackTrace ();
    }

}