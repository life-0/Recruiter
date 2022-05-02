package com.life.POJO.file;

/*
 *@Author: life-0
 *@ClassName: FileProperties
 *@Date: 2022/5/2 14:59
 *TODO @Description:

 */


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}