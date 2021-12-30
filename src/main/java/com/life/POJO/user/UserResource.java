package com.life.POJO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResource implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * 唯一标识
    */
    private String number;

    /**
    * ID
    */
    private Integer id;

    /**
    * 图片路径
    */
    private String imgpath;

    /**
    * 附件路径
    */
    private String appendix;
}