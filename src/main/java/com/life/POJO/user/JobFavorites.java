package com.life.POJO.user;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 职位收藏表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobFavorites {
    /**
     * 唯一标识
     */
    @TableField(value = "number", fill = FieldFill.INSERT)
    private String number;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 职位标识
     */
    private String jobNumber;

    /**
     * 状态 0: 可使用 1: 失效
     */
    private Boolean state;

    /**
     * 更新时间     value指数据库字段
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 创建时间     value指数据库字段
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
}