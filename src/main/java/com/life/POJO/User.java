package com.life.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;     //账号

    private String number;  //唯一标识号

    private String permission;//临时权限

    private String role;    //角色

    private String password;//密码

    private String email;   //邮箱

    private String name;    //真实名字

    private Date createTime;//创建时间

    private String iphone;  //电话

    private String nickname;//昵称


}