package com.life.POJO.user;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户对话表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class UserDialogue {
    /**
     * 唯一标识
     */
    private String number;

    @TableId
    private Integer id;

    /**
     * 联系对象id
     */
    private Integer contactUserId;

    /**
     * 对话记录路径
     */
    private String recordPath;
}