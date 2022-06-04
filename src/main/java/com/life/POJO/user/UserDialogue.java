package com.life.POJO.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户对话表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class UserDialogue implements Serializable {
    /**
     * 唯一标识
     */
    @TableField(value = "number", fill = FieldFill.INSERT)
    @MppMultiId
    private String number;

    @TableField(value = "id")
    private Integer id;

    /**
     * 联系对象id
     */
    @TableField(value = "contact_user_id")
    private Integer contactUserId;

    /**
     * 对话记录路径
     */
    private String recordPath;
}