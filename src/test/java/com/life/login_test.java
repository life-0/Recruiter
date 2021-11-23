package com.life;

import com.life.Mapper.user.UserLoginMapper;
import com.life.POJO.user.UserLogin;
import com.life.Service.user.UserLoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/*
 *@Author: life-0
 *@ClassName: login_test
 *@Date: 2021/11/22 11:47
 *TODO @Description:

 */
@SpringBootTest
public class login_test {
    @Resource
    private UserLoginMapper userLoginService;
    @Test
    public void test_userLogin(){
        UserLogin userLogin = userLoginService.selectByAccount ("111");
        System.out.println (userLogin.toString ());
    }
}
