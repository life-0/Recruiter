package com.life.POJO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserId {
    /*用户id*/
    private int id;
    /*唯一标识*/
    private String number;

    public UserId(String Number) {
        this.number = Number;
    }
}