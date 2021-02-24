package com.life.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identity {
    private String number;  //唯一标识

    private String name;    //角色名

    private String account; //账号

    private String id;      //角色标识值
}