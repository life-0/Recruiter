package com.life;

import com.life.POJO.user.UserInfo;
import com.life.Service.user.UserInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/*
 *@Author: life-0
 *@ClassName: User_test
 *@Date: 2021/11/23 16:58
 *TODO @Description:

 */
@SpringBootTest
public class User_test {
    @Resource
    private UserInfoServiceImpl userInfoService;

    @Test
    public void test_showAll() {
        for (UserInfo userInfo : userInfoService.showAll ()) {
            System.out.println ("userInfo: " + userInfo);
        }

    }

}
