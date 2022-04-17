package com.life.api.vo;

import lombok.Data;

/*
 *@Author: life-0
 *@ClassName: JsonMessage
 *@Date: 2022/4/17 11:26
 *TODO @Description: 控制器响应结果实体类，返回接口调用信息描述

 */
@Data
public class JsonMessage {

    private static final long serialVersionUID = -7127875856370230011L;

    /**
     * 状态码
     */
    private int status = 200;
    /**
     * 消息描述
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    public JsonMessage() {
    }

    public JsonMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public JsonMessage(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


}