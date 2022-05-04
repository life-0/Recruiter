package com.life.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@Author: life-0
 *@ClassName: UserRegisterDTO
 *@Date: 2022/5/4 17:23
 *TODO @Description:

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 账号
     */
    @ApiModelProperty(value = "账号",dataType = "String")
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",dataType = "String")
    private String password;
}
