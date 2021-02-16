package com.life.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id; //

    private String number;

    private String password;

    private String role;

    private String email;

    private String name;

    private String createTime;

    private String iphone;

    private String nickname;

    private String account;
}