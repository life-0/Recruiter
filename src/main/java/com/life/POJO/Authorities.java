package com.life.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authorities {
    private String number;  //唯一标识

    private String competence;//权限

    private String name;    //权限名

    private String token;   //令牌
}