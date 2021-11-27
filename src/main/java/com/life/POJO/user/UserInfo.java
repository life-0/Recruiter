package com.life.POJO.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("userInfo")
public class UserInfo {
    /**
     * 唯一标识
     */
    private String number;

    /**
     * ID
     */
    private Integer id;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 住址
     */
    private String address;

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
    private Date create_time;

    public UserInfo(String number, Integer id) {
        this.number = number;
        this.id = id;
    }
}