package com.life.websocket.net;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 *@Author: life-0
 *@ClassName: socketPool
 *@Date: 2022/4/15 10:36
 *TODO @Description:

 */
public class socketPool {

    /**
     * 用来存放每个客户端对应的 WebSocketServer 对象
     */
    private static ConcurrentHashMap<String, Session> webSocketMap = new ConcurrentHashMap<> ();

    public static void add(Session session, String userKey) {
        if (!userKey.isEmpty () && session != null) {
            webSocketMap.put (userKey, session);
        }
    }

    /**
     * 根据Key删除连接
     *
     * @param key 主键
     */
    public static void remove(String key) {
        if (!key.isEmpty ()) {
            webSocketMap.remove (key);
        }
    }
    /**
     * 获取在线session池
     * @return 获取session池
     */
    public static Map<String, Session> sessionPool() {
        return webSocketMap;
    }



}