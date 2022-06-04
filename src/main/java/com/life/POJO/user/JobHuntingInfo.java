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
import java.util.Date;

/**
 * 求职信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class JobHuntingInfo implements Serializable {
    /**
     * 唯一标识
     */
    @TableField(value = "number", fill = FieldFill.INSERT)
    @MppMultiId
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

    /**
     * 专业技能
     */
    private String professionalSkill;

    /**
     * 作品
     */
    private String works;

    /**
     * 状态 0: 可用 1:不可用
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