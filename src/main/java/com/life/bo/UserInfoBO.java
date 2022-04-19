package com.life.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class UserInfoBO {
    private static final long serialVersionUID = 1L;
    /**
     * 唯一标识
     */
    private String number;

    /**
     * ID
     */
    @TableId
    private Integer id;

    /**
     * 真实姓名
     */
    private String name;
    /*
     *  年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 住址
     */
    private String address;

    /**
     * 职位
     */
    private String position;
    /**
     * 公司名
     */
    private String firmName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String iphone;

    /**
     * 微信号
     */
    private String vx;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 简介
     */
    private String introduction;

    /**
     * 权限
     */
    private String permission;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态 0: 可使用 1: 失效
     */
    private Byte state;


    public UserInfoBO(String number, int id) {
        this.number = number;
        this.id = id;
    }
}