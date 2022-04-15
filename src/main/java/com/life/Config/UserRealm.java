package com.life.Config;


import com.life.POJO.user.UserLogin;
import com.life.POJO.user.UserRank;

import com.life.Service.user.UserLoginServiceImpl;
import com.life.Service.user.UserRankServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;


/*
 *@Author life-0
 *@ClassName UserRealm
 *@Date 2020/8/30 11:43
 *@Description: 
 TODO        自定义的UserRealm
*/

public class UserRealm extends AuthorizingRealm {
    @Lazy
    @Resource
    private UserRankServiceImpl userRankService;
    @Lazy
    @Resource
    private UserLoginServiceImpl userLoginService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println ("执行了=>授权doGetAuthorizationInfo 授权");

        //给予用户权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo ();

        //得到受过认证后,从数据库中拿到的登录用户对象 (PrincipalCollection集合)
        Subject subject = SecurityUtils.getSubject ();  //等同principalCollection中的类型,

        UserLogin principal = (UserLogin) subject.getPrincipal ();  //获得当前登录对象
        UserRank userRankResources = userRankService.queryById (principal.getId ());//查询资源表是否有权限
        info.addStringPermissions (userRankResources.splitPermission ());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println ("执行了=>认证doGetAuthenticationInfo 认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接真实数据库

//        UserLogin user = userLoginService.selectByAccount (userToken.getUsername ());

        UserLogin user = userLoginService.querySelective (
                new UserLogin ().setAccount (userToken.getUsername ()).
                        setPassword (String.valueOf (userToken.getPassword ()))
        );
        /*System.out.println (user.toString ());*/
        if (user == null) {
            return null;
        }
        //密码验证  shiro来自己做   将数据库用户对象到当前用户对象中
        return new SimpleAuthenticationInfo (user, user.getPassword (), user.getAccount ());
    }
}
