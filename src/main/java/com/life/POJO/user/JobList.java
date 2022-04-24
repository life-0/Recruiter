package com.life.POJO.user;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 职位列表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class JobList implements Serializable {
    /**
     * 唯一标识
     */
    private String number;
    @TableId
    private Integer id;
    /**
     * 公司id
     */
    private Integer firmId;

    /**
     * 职位
     */
    private String position;

    /**
     * 薪资
     */
    private String salary;

    /**
     * 工作地址
     */
    private String address;

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
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;
}