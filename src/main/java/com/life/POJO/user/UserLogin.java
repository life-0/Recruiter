package com.life.POJO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("userLogin")
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 唯一标识
     */
    private String number;

    /**
     * ID
     */
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
}