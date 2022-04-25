package com.life.POJO.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class UserResource implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * 唯一标识
    */
    @TableField(value = "number", fill = FieldFill.INSERT)
    private String number;

    /**
    * ID
    */
    @TableId
    private Integer id;

    /**
    * 图片路径
    */
    private String imgpath;

    /**
    * 附件路径
    */
    private String appendix;
}