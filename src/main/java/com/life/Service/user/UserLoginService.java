package com.life.Service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.life.POJO.user.UserLogin;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface UserLoginService extends IService<UserLogin> {
    List<UserLogin> queryAll();
}
