package com.life;

import com.life.POJO.user.*;
import com.life.Service.user.*;
import com.life.Utils.NumberUtil;
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
    private UserIdServiceImpl userIdService;
    @Resource
    private UserInfoServiceImpl userInfoService;
    @Resource
    private UserLoginServiceImpl userLoginService;
    @Resource
    private UserRankServiceImpl userRankService;
    @Resource
    private UserResourceServiceImpl userResourceService;

    @Test
    public void test_showAll() {
        for (UserInfo userInfo : userInfoService.showAll ()) {
            System.out.println ("userInfo: " + userInfo);
        }
    }

    @Test
    public void test_add() {
        NumberUtil numberUtil = new NumberUtil ();
        String number = numberUtil.getRandomNumber ();  //Userid中的Number

        UserId target = new UserId (5, "17827180e80841a080f50b670be7bb3c");
        userIdService.insertSelective (target);/*创建用户ID*/
//        UserId target = userIdService.selectById (null, number);    //获得UserID中的ID*/

        UserInfo userInfo = new UserInfo (numberUtil.getRandomNumber (), target.getId ());    //添加用户信息
        userInfoService.insertSelective (userInfo);

        UserLogin userLogin = new UserLogin (numberUtil.getRandomNumber (),
                target.getId (), "1", "323");// 添加UserLogin账号密码
        userLoginService.insert (userLogin);

        UserRank userRank = new UserRank (numberUtil.getRandomNumber (), target.getId (), "gerneralUser", "null");
        userRankService.insert (userRank);

        UserResource userResource = new UserResource (numberUtil.getRandomNumber (), target.getId (), "", "");
        userResourceService.insert (userResource);
    }

    @Test
    public void test_del() {
        /*级联删除, 删除UserID中的id主键即可*/
        System.out.println (userIdService.deleteByPrimaryKey (3, null));
    }
    @Test
    public void test_AutoIncrementID(){
        userIdService.resetAutoIncrementID (userIdService.maxID ());
        System.out.println (userIdService.maxID ());
    }
}
