package com.life.Controller;


import com.life.Service.IdentityServiceImpl;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/*
 *@Author: life-0
 *@ClassName: AuthorityController
 *@Date: 2021/11/16 17:21
 *TODO @Description:
                    权限管理
 */
@Controller
public class AuthorityController {
    @Resource
    IdentityServiceImpl identityService;

}
