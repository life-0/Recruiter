package com.life.POJO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户对话表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDialogue {
    /**
    * 唯一标识
    */
    private String number;

    private Integer id;

    /**
    * 联系对象id
    */
    private String contactUserId;
}