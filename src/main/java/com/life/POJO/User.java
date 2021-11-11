package com.life.POJO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户类")    //用户显示在api测试的实体类中
public class User {
    @ApiModelProperty("账号")
    private Integer id;     //账号

    @ApiModelProperty("唯一标识号")
    private String number;  //唯一标识号

    @ApiModelProperty("临时权限")
    private String permission;//临时权限

    @ApiModelProperty("角色")
    private String role_ID;    //角色

    @ApiModelProperty("密码")
    private String password;//密码

    @ApiModelProperty("邮箱")
    private String email;   //邮箱

    @ApiModelProperty("真实名字")
    private String name;    //真实名字

    @ApiModelProperty("创建时间")
    private Date createTime;//创建时间

    @ApiModelProperty("电话")
    private String iphone;  //电话

    @ApiModelProperty("昵称")
    private String nickname;//昵称


}