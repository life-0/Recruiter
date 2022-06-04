package com.life.Controller.user;

import com.life.POJO.user.*;
import com.life.Service.user.*;
import com.life.Utils.NumberUtil;
import com.life.api.vo.Result;
import com.life.dto.UserRegisterDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
 *@Author: life-0
 *@ClassName: RegisterController
 *@Date: 2022/5/4 17:20
 *TODO @Description:

 */
@RestController
@RequestMapping("/register")
@Api("注册接口")
public class RegisterController {
    @Resource
    UserIdServiceImpl userIdService;
    @Resource
    UserLoginServiceImpl userLoginService;
    @Resource
    UserInfoServiceImpl userInfoService;
    @Resource
    UserRankServiceImpl userRankService;
    @Resource
    JobFavoritesServiceImpl jobFavoritesService;
    @Resource
    JobHuntingInfoServiceImpl jobHuntingInfoService;

    @ApiOperation("增加用户")
    @PostMapping("/addUser")
    public Result<?> addUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        String number = NumberUtil.getRandomNumber ();
        if (userIdService.addByUserId (new UserId (number))) {
            UserId userId = userIdService.queryByNumber (number);
            if (userId != null) {
                userLoginService.addUserLogin (new UserLogin ()
                        .setId (userId.getId ())
                        .setAccount (userRegisterDTO.getAccount ())
                        .setPassword (userRegisterDTO.getPassword ()));
                userInfoService.addUserInfo (new UserInfo ()
                        .setId (userId.getId ())
                        .setName (userRegisterDTO.getName ())
                        .setState (true));
                userRankService.addUserRank (new UserRank ()
                        .setId (userId.getId ())
                        .setIdentity ("user")
                        .setPermission ("client"));
                jobFavoritesService.addJobFavorites (new JobFavorites ()
                        .setUserId (userId.getId ())
                        .setState (true));
                jobHuntingInfoService.addJobHuntingInfo (new JobHuntingInfo ()
                        .setId (userId.getId ()));

            }

            return Result.OK (true);
        } else {
            return Result.OK (false);
        }
    }
}
