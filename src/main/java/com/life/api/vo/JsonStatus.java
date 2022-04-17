package com.life.api.vo;/*
 *@Author: life-0
 *@ClassName: JsonStatus
 *@Date: 2022/4/17 11:28
 *TODO @Description:

 */

public enum JsonStatus {

    /**
     * 操作成功
     */
    SUCCESS (200, "操作成功"),
    /**
     * 操作失败
     */
    FAILURE (500, "操作失败"),
    /**
     * 请求错误
     */
    REQUEST_ERROR (100, "请求错误"),
    /**
     * 服务端程序错误
     */
    SERVER_INTERNAL_ERROR (500, "服务端内部错误"),
    /**
     * 服务类错误
     */
    SERVICE_EXCEPTION (600, "业务逻辑错误");


    /**
     * 状态码
     */
    private int status;
    /**
     * 信息描述
     */
    private String message;

    JsonStatus() {
    }

    JsonStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
