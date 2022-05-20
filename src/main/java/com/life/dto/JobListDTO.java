package com.life.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 *@Author: life-0
 *@ClassName: JobListDTO
 *@Date: 2022/5/20 11:20
 *TODO @Description:

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobListDTO {
    /**
     * 唯一标识
     */
    private String number;

    /**
     * 发布者id
     */

    private Integer announcerId;

    /**
     * 公司id
     */
    private Integer firmId;

    /**
     * 公司名称
     */
    private String firmName;

    /**
     * 职位
     */
    private String position;
    /**
     * 职位
     */
    private String technologyStack;
    /**
     * 薪资
     */
    private String salary;

    /**
     * 工作地址
     */
    private String address;
    /**
     * 工作经验
     */
    private String workExperience;
    /**
     * 学历
     */
    private String education;

    /**
     * 需求人数
     */
    private String requireCount;

    /**
     * 申请人数
     */
    private String applicantCount;

    /**
     * 应聘条件
     */
    private String applicationConditions;
    /**
     * 工作性子
     */
    private String nature;
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
