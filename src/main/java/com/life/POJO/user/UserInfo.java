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
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private Integer id;

    /**
     * 真实姓名
     */
    @ApiModelProperty(name = "name", value = "真实姓名", dataType = "String")
    private String name;

    /**
     * 昵称
     */
    @ApiModelProperty(name = "nickname", value = "昵称", dataType = "String")
    private String nickname;

    /**
     * 性别
     */
    @ApiModelProperty(name = "gender", value = "性别", dataType = "String")
    private Boolean gender;

    /**
     * 住址
     */
    @ApiModelProperty(name = "address", value = "住址", dataType = "String")
    private String address;

    /**
     * 邮箱
     */
    @ApiModelProperty(name = "email", value = "邮箱", dataType = "String")
    private String email;

    /**
     * 电话
     */
    @ApiModelProperty(name = "iphone", value = "电话", dataType = "String")
    private String iphone;

    /**
     * 微信号
     */
    @ApiModelProperty(name = "vx", value = "微信号", dataType = "String")
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