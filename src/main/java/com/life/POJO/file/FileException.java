package com.life.POJO.file;

/*
 *@Author: life-0
 *@ClassName: FileException
 *@Date: 2022/5/2 15:04
 *TODO @Description:

 */
public class FileException extends RuntimeException{
    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}