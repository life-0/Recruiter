package com.life.Config;



import com.life.POJO.user.UserId;
import com.life.POJO.user.UserLogin;
import com.life.POJO.user.UserRank;
import com.life.Service.user.UserIdServiceImpl;
import com.life.Service.user.UserLoginServiceImpl;
import com.life.Service.user.UserRankServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
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
    @Resource
    private UserIdServiceImpl userIdService;
    @Resource
    private UserRankServiceImpl userRankService;
    @Resource
    private UserLoginServiceImpl userLoginService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println ("执行了=>授权doGetAuthorizationInfo 授权");

        //给予用户权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo ();

        //得到当前登录用户对象
        Subject subject = SecurityUtils.getSubject ();
//        Admin principal = (Admin) subject.getPrincipal ();//拿到user对象
        UserId principal = (UserId) subject.getPrincipal ();  //获得当前登录对象

        UserRank userRankResources = userRankService.selectById (principal.getId ());//查询资源表是否有权限

//        System.out.println ("Role:" + principal.getRole ());
//        List<String> list = Arrays.asList (principal.getRole ().split (";"));//将权限令牌转换为集合参数
//        info.addStringPermissions (list);
//        System.out.println (resources.getPurview ());//打印授权列表
        info.addStringPermissions (userRankResources.splitPermission ());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println ("执行了=>认证doGetAuthenticationInfo 认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接真实数据库
        //Admin user = service.getAdmin (Integer.parseInt (userToken.getUsername ()));

        UserLogin user = userLoginService.selectById (Integer.parseInt (userToken.getUsername ()));
        System.out.println (user.toString ());
        if (user == null) {
            return null;
        }
        //密码验证  shiro来自己做   将数据库用户对象到当前用户对象中
        return new SimpleAuthenticationInfo (user, user.getPassword (), "");
    }
}
