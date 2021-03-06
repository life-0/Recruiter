package com.life.Controller;

/*
 *@Author: life-0
 *@ClassName: SwaggerController
 *@Date: 2021/3/6 18:24
 *TODO @Description:

 */

import com.life.POJO.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "User", description = "这个是用户信息 ", tags = "用户信息")
@RequestMapping("/user")
public class SwaggerController {

    @ApiOperation(value = "获取用户列表", notes = "")
    @GetMapping("/UserGet")
    public List<User> getUserList() {
        return null;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @PostMapping("/UserPost")
    public String postUser(@RequestBody User user) {
        return "success";
    }
}
