package com.life.Mapper.user;

import com.life.POJO.user.UserDialogue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDialogueMapper {
    int deleteByPrimaryKey(String number);

    int insert(UserDialogue record);

    int insertSelective(UserDialogue record);

    UserDialogue selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(UserDialogue record);

    int updateByPrimaryKey(UserDialogue record);
}