package com.life.POJO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRank {
    /**
    * 唯一标识
    */
    private String number;

    /**
    * ID
    */
    private Integer id;

    /**
    * 身份
    */
    private String identity;

    /**
    * 权限
    */
    private String permission;
}