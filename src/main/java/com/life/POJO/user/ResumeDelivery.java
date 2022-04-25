package com.life.POJO.user;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
    * 职位投递表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class ResumeDelivery {
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
    * 是否使用在线简历
    */
    private Boolean isOnlineResume;

    /**
    * 职位标识
    */
    private String jobNumber;

    /**
    * 公司id
    */
    private Integer firmId;

    /**
    * 状态 0: 可使用 1: 失效
    */
    private Boolean state;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 创建时间
    */
    private Date createTime;
}