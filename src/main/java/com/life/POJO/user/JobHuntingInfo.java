package com.life.POJO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
    * 求职信息表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class JobHuntingInfo {
    /**
    * 唯一标识
    */
    private String number;

    private Integer id;

    /**
    * 学校名称
    */
    private String school;

    /**
    * 学历
    */
    private String education;

    /**
    * 求职状态
    */
    private String jobStatus;

    /**
    * 期望工资
    */
    private String expectSalary;

    /**
    * 期望工资
    */
    private String expectCity;

    /**
    * 附件路径
    */
    private String appendix;

    /**
    * 期望行业
    */
    private String expectIndustry;
}