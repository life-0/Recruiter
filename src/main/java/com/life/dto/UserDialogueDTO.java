package com.life.dto;

import com.life.POJO.user.UserDialogue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@Author: life-0
 *@ClassName: UserDialogueDTO
 *@Date: 2022/4/17 21:49
 *TODO @Description: 用户对话对象

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDialogueDTO {
    /**
     * 原userID
     */
    private Integer id;
    /**
     * 联系对象id
     */
    private Integer contactUserId;

    /**
     * 真实姓名
     */
    private String contactUserName;

    /**
     * 图片路径
     */
    private String imgPath;

    /**
     * 对话记录路径
     */
    private String recordPath;

    public UserDialogueDTO(UserDialogue userDialogue, String contactUserName,String imgPath){
        this.id=userDialogue.getId ();
        this.contactUserId=userDialogue.getContactUserId ();
        this.contactUserName=contactUserName;
        this.imgPath=imgPath;
        this.recordPath=userDialogue.getRecordPath ();
    }
}
