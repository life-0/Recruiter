package com.life.Service.user;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.Mapper.user.UserDialogueMapper;
import com.life.POJO.user.UserDialogue;
import com.life.Service.user.UserDialogueService;
@Service
public class UserDialogueServiceImpl implements UserDialogueService{

    @Resource
    private UserDialogueMapper userDialogueMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return userDialogueMapper.deleteByPrimaryKey(number);
    }

    @Override
    public int insert(UserDialogue record) {
        return userDialogueMapper.insert(record);
    }

    @Override
    public int insertSelective(UserDialogue record) {
        return userDialogueMapper.insertSelective(record);
    }

    @Override
    public UserDialogue selectByPrimaryKey(String number) {
        return userDialogueMapper.selectByPrimaryKey(number);
    }

    @Override
    public int updateByPrimaryKeySelective(UserDialogue record) {
        return userDialogueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserDialogue record) {
        return userDialogueMapper.updateByPrimaryKey(record);
    }

}
