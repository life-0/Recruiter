package com.life.POJO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /*
     * 分割资源权限
     */
    public List<String> splitPermission() {
        return Arrays.asList (permission.split (";"));
    }
}