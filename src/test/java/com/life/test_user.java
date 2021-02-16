package com.life;

import com.life.POJO.User;
import com.life.Service.UserService;
import com.life.Service.UserServiceImpl;
import com.life.Utils.NumberUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 *@Author: life-0
 *@ClassName: test_user
 *@Date: 2021/2/3 12:42
 *TODO @Description: 测试user

 */
@SpringBootTest
public class test_user {
    @Autowired
    UserServiceImpl userService;

    @Test
    public void add_user() {
        NumberUtil number = new NumberUtil ();
        User user_1 = new User (1, number.getRandomNumber (), "123",
                "学生", "123456@qq.com", "张三", "2019-10-12",
                "18376840955", "阿哈哈哈哈哈", "011054");
        System.out.println (userService.insert (user_1));
    }
    @Test
    public void query_user(){
        User user = userService.queryUser (0);
        System.out.println (user);

    }
}
