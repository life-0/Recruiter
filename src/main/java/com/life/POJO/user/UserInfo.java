package com.life.POJO.user;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("userInfo")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 唯一标识
     */
    @ApiModelProperty("唯一标识")
    private String number;

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Integer id;

    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String name;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Boolean gender;

    /**
     * 住址
     */
    @ApiModelProperty("住址")
    private String address;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String iphone;

    /**
     * 微信号
     */
    @ApiModelProperty("微信号")
    private String vx;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    public UserInfo(String number, Integer id) {
        this.number = number;
        this.id = id;
    }
}