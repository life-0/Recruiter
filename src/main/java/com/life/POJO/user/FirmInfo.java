package com.life.POJO.user;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 企业信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class FirmInfo implements Serializable {
    /**
     * 唯一标识
     */
    @ApiModelProperty(value = "唯一标识")
    @MppMultiId
    @TableField(value = "number", fill = FieldFill.INSERT)
    private String number;

    /*自增*/
    @ApiModelProperty(value = "公司id")
    @MppMultiId
    @TableField(value = "firm_id")
    private Integer firmId;

    /**
     * 公司名字
     */
    private String firmName;

    /**
     * 公司头像
     */
    private String firmAvatar;

    /**
     * 融资规模
     */
    private String financingScale;
    /**
     * 福利
     */
    private String welfare;
    /**
     * 公司地址
     */
    private String address;

    /**
     * 企业人数
     */
    private String firmNumber;

    /**
     * 企业官网
     */
    private String officialUrl;

    /**
     * 企业简介
     */
    private String introduction;

    /**
     * 企业领域
     */
    private String field;

    /**
     * 成立时间
     */
    private Date established;

    /**
     * 法人
     */
    private String legalPerson;

    /**
     * 注册资本
     */
    private String registeredCapital;

    /**
     * 机构类型
     */
    private String organizationType;

    /**
     * 公司信息链接
     */
    private String infoUrl;

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