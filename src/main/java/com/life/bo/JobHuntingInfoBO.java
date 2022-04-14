package com.life.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/*
 *@Author: life-0
 *@ClassName: JobHuntingInfoBO
 *@Date: 2022/4/12 21:12
 *TODO @Description:    持久化层复杂对象

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobHuntingInfoBO {
    /**
     * 唯一标识
     */
    private String number;

    private Integer id;

    /**
     * 求职状态
     */
    private String jobStatus;

    /**
     * 职位
     */
    private String position;

    /**
     * 最低工资
     */
    private Integer salaryMin;

    /**
     * 最高工资
     */
    private Integer salaryMax;

    /**
     * 期望城市
     */
    private ArrayList<String> expectCity;

    /**
     * 工作性质
     */
    private String jobNature;

    /**
     * 期望行业
     */
    private String expectIndustry;

    /**
     * 学校名称
     */
    private String colleges;

    /**
     * 学历
     */
    private String education;

    /**
     * 专业
     */
    private String profession;

    /**
     * 学年
     */
    private ArrayList<Long> academicYear;

    /**
     * 附件路径
     */
    private String appendix;
}
