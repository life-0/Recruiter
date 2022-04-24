package com.life.Controller.user;

import com.life.POJO.user.UserDialogue;
import com.life.Service.user.UserDialogueServiceImpl;

import com.life.api.vo.Result;
import com.life.dto.UserDialogueDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 *@Author: life-0
 *@ClassName: UserDialogueControlle
 *@Date: 2022/4/17 21:05
 *TODO @Description:

 */
@RestController
@Api("用户对话接口")
@RequestMapping("/userDialogue")
public class UserDialogueController {
    @Resource
    private UserDialogueServiceImpl userDialogueService;

    @ApiOperation("展示所有的用户")
    @PostMapping("/getUserDialogue")
    public Result<?> getUserDialogue(@RequestBody UserDialogue userDialogue) {
        System.out.println (userDialogue.toString ());
        List<UserDialogueDTO> userDialogueDTOS = null;
        if (userDialogue != null) {
            System.out.println ("-----------");
            userDialogueDTOS = userDialogueService.queryBySelective (userDialogue);
            return Result.OK (userDialogueDTOS);

        } else {
            return Result.OK (userDialogueService.queryAll ());
        }

    }

    @PostMapping(value = {"/updateUserDialogue"})
    public Result<?> updateUserDialogue(@RequestBody UserDialogue userDialogue) {
        System.out.println (userDialogue.toString ());
        if (userDialogueService.updateUserDialogue (userDialogue)) {
            return getUserDialogue (new UserDialogue ().setId (userDialogue.getId ()));
        } else {
            List<String> list = new ArrayList<> ();
            return Result.OK (list);
        }
    }


    @PostMapping("/addUserDialogue")
    public Result<?> addUserDialogue(@RequestBody UserDialogue userDialogue) {
        if (userDialogueService.addUserDialogue (userDialogue)) {
            return getUserDialogue (new UserDialogue ().setId (userDialogue.getId ()));
        } else {
            List<String> list = new ArrayList<> ();
            return Result.OK (list);
        }
    }

    @PostMapping("/delUserDialogue")
    public Result<?> delUserDialogue(@RequestBody List<Integer> idList) {
        List<String> list = new ArrayList<> ();
        if (userDialogueService.delUserDialogue (idList)) {
            return Result.OK ("OK");
        } else {
            return Result.OK (list);
        }
    }
}
