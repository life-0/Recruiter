package com.life.Service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.life.POJO.user.UserDialogue;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.Mapper.user.UserDialogueMapper;

import java.util.List;

@Service
public class UserDialogueServiceImpl extends ServiceImpl<UserDialogueMapper, UserDialogue> implements UserDialogueService{

    @Resource
    private UserDialogueMapper userDialogueMapper;


    public List<UserDialogue> queryBySelective(UserDialogue record) {
        QueryWrapper<UserDialogue> wrapper = new QueryWrapper<> (record);
        List<UserDialogue> UserDialogues = userDialogueMapper.selectList (wrapper);
        for (UserDialogue info : UserDialogues) {
            System.out.println (info.toString ());
        }
        return UserDialogues;
    }

    public List<UserDialogue> queryAll() {
        QueryWrapper<UserDialogue> wrapper = new QueryWrapper<> ();
        return userDialogueMapper.selectList (wrapper);
    }

    public Boolean updateUserDialogue(UserDialogue UserDialogue) {
        UpdateWrapper<UserDialogue> wrapper = new UpdateWrapper<> ();
        wrapper.eq ("id", UserDialogue.getId ());
        int result = userDialogueMapper.update (UserDialogue, wrapper);
        return result > 0;
    }

    public Boolean addUserDialogue(UserDialogue UserDialogue) {
        int result = userDialogueMapper.insert (UserDialogue);
        return result > 0;
    }

    public Boolean delUserDialogue(List<Integer> idList) {
        int result = userDialogueMapper.deleteBatchIds (idList);
        return result > 0;
    }
}
