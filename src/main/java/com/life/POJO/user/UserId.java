package com.life.POJO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserId implements Serializable {
    private static final long serialVersionUID = 1L;
    /*用户id*/
    private int id;
    /*唯一标识*/
    private String number;

    public UserId(String Number) {
        this.number = Number;
    }
}