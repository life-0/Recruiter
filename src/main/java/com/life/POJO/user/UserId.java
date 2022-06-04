package com.life.POJO.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class UserId implements Serializable {
    private static final long serialVersionUID = 1L;
    /*用户id*/
    private Integer id;
    /*唯一标识*/
    @TableField(value = "number", fill = FieldFill.INSERT)
    @MppMultiId
    private String number;

    public UserId(String Number) {
        this.number = Number;
    }
}