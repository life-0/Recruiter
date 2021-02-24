package com.life.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resources {
    private String number;  //唯一标识值

    private boolean student;    //学生表信息权限

    private boolean teacher;    //教师表信息权限

    private boolean company;    //身份表信息权限

    private Integer id;         //用户ID

    public List<String> getPurview() {  //权限集合
        List<String> list = new ArrayList<> ();
        list.add ("stu:" + student);
        list.add ("tea:" + teacher);
        list.add ("com:" + company);
        return list;
    }

}