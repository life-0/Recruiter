package com.life.Service.user;

import com.life.POJO.user.UserDialogue;
public interface UserDialogueService{


    int deleteByPrimaryKey(String number);

    int insert(UserDialogue record);

    int insertSelective(UserDialogue record);

    UserDialogue selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserDialogue record);

    int updateByPrimaryKey(UserDialogue record);

}
