package com.life.POJO.user;

import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId
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
    private String expectCity;

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
    private String academicYear;

    /**
     * 附件路径
     */
    private String appendix;
}