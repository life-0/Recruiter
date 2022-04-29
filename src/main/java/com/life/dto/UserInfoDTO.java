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

    public UserInfoDTO() {
    }

    public UserInfoDTO(Integer id, String imgPath, boolean state, String firmId, String position, String identity, String permission, String token) {
        this.id = id;
        this.imgPath = imgPath;
        this.state = state;
        this.firmId = firmId;
        this.position = position;
        this.identity = identity;
        this.permission = permission;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getFirmId() {
        return firmId;
    }

    public void setFirmId(String firmId) {
        this.firmId = firmId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
