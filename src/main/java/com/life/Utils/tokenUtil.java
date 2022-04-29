package com.life.Utils;

import com.life.POJO.user.UserLogin;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*
 *@Author: life-0
 *@ClassName: tokenUtil
 *@Date: 2022/4/2 17:26
 *TODO @Description: token令牌

 */

@Component
public class tokenUtil {

    /**
     * 创建map用于存储所有的令牌
     * <p>
     * token  -  User
     */
    private static Map<String, UserLogin> tokenMap = new HashMap<> ();


    /**
     * 生成token，存储token-user对应关系
     * 返回token令牌
     *
     * @param user
     * @return
     */
    public static String generateToken(UserLogin user) {
        //生成唯一不重复的字符串
//        String token = UUID.randomUUID ().toString ();
        String token=NumberUtil.getRandomNumber ();
        tokenMap.put (token, user); //这是存放在tokenMap,重启会消失
        return token;
    }

    /**
     * 验证token是否合法
     *
     * @return
     * @param: token
     */
    public static boolean verify(String token) {
        return tokenMap.containsKey (token);
    }

    /**
     * 根据token获取用户信息
     *
     * @param token
     * @return
     */
    public static UserLogin getUser(String token) {
        return tokenMap.get (token);
    }


}