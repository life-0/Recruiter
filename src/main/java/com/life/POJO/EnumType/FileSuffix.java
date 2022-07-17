package com.life.POJO.EnumType;

import com.life.api.vo.CommonConstant;
import com.life.api.vo.Result;
import lombok.Data;

import java.util.*;

/*
 *@Author: life-0
 *@ClassName: image
 *@Date: 2022/7/14 20:20
 *TODO @Description:
            图片后缀枚举
 */
@Data
public class FileSuffix<T> {
    private LinkedHashSet<String> suffixList = new LinkedHashSet<> ();

    public FileSuffix() {

    }

    public static LinkedHashSet<String> getImageSuffixList() {
        FileSuffix<Object> fileSuffix = new FileSuffix<> ();
        Collections.addAll (fileSuffix.suffixList,
                ".xbm", ".tif", ".pjp",
                ".svgz", ".jpg", ".jpeg", ".ico", ".tiff",
                ".gif", ".svg", ".jfif",
                ".webp", ".png", ".bmp",
                ".pjpeg", ".avif");
        return fileSuffix.suffixList;
    }
}
