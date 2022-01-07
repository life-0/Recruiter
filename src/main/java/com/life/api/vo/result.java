package com.life.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*
 *@Author: life-0
 *@ClassName: result
 *@Date: 2022/1/7 10:45
 *TODO @Description:  result 未修改完成

 */

@ApiModel("api通用返回数据")
public class result<T> {
    //uuid,用作唯一标识符，供序列化和反序列化时检测是否一致
    private static final long serialVersionUID = 7498483649536881777L;
    //标识代码，0表示成功，非0表示出错
    @ApiModelProperty("标识代码,0表示成功，非0表示出错")
    private Integer code;

    //提示信息，通常供报错时使用
    @ApiModelProperty("提示信息,供报错时使用")
    private String msg;

    //正常返回时返回的数据
    @ApiModelProperty("返回的数据")
    private T data;

    //constructor
    public result() {
    }

    //constructor
    public result(Integer status, String msg, T data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    //返回成功数据
    public result<T> success(T data) {
        return new result<T> (this.getCode (), this.getMsg (), data);
    }

    public static result<Object> success(Integer code, String msg) {
        return new result<Object> (code, msg, null);
    }

    //返回出错数据
    public static result<Object> error(Integer code) {
        return new result<Object> (code, "error", null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
