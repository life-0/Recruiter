package com.life.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@Author: life-0
 *@ClassName: UserInfoDTO
 *@Date: 2022/4/29 17:25
 *TODO @Description:

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户头像
     */
    private String imgPath;

    /**
     * 状态
     */
    private boolean state;

    /**
     * 公司id
     */
    private String firmId;

    /**
     * 职位
     */
    private String position;

    /**
     * 身份
     */
    private String identity;

    /**
     * 权限
     */
    private String permission;

    /**
     * 登录令牌权限
     */
    private String token;


}
