package com.life.Config;


import com.life.POJO.Resources;
import com.life.POJO.User;
import com.life.POJO.test.Admin;
import com.life.Service.ResourcesServiceImpl;
import com.life.Service.RoleService.AdminServiceImpl;
import com.life.Service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/*
 *@Author life-0
 *@ClassName UserRealm
 *@Date 2020/8/30 11:43
 *@Description: 
 TODO        自定义的UserRealm
*/

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl service;
    @Autowired
    private ResourcesServiceImpl resourcesService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println ("执行了=>授权doGetAuthorizationInfo 授权");

        //给予用户权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo ();

        //得到当前登录用户对象
        Subject subject = SecurityUtils.getSubject ();
//        Admin principal = (Admin) subject.getPrincipal ();//拿到user对象
        User principal=(User) subject.getPrincipal ();  //获得当前登录对象
        Resources resources = resourcesService.selectByID (principal.getId ());//查询资源表是否有权限

//        System.out.println ("Role:" + principal.getRole ());
//        List<String> list = Arrays.asList (principal.getRole ().split (";"));//将权限令牌转换为集合参数
//        info.addStringPermissions (list);
        System.out.println (resources.getPurview ());
        info.addStringPermissions (resources.getPurview ());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println ("执行了=>认证doGetAuthenticationInfo 认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接真实数据库
        //Admin user = service.getAdmin (Integer.parseInt (userToken.getUsername ()));
        User user = service.queryUserByID (Integer.parseInt (userToken.getUsername ()));
        System.out.println (user.toString ());
        if (user == null) {
            return null;
        }
        //密码验证  shiro来自己做   将数据库用户对象到当前用户对象中
        return new SimpleAuthenticationInfo (user, user.getPassword (), "");
    }
}
