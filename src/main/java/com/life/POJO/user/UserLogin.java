package com.life.POJO.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@Accessors(chain = true)  //链式写法
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 唯一标识
     */
    @ApiModelProperty("唯一标识")
    private String number;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID",dataType = "Integer")
    private Integer id;

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