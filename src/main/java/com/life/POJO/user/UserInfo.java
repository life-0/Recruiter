package com.life.POJO.user;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class UserInfo {
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
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态 0: 可使用 1: 失效
     */
    private Boolean state;


    public UserInfo(String number, int id) {
        this.number = number;
        this.id = id;
    }
}