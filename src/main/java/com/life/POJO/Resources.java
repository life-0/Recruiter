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
    private String number;

    private boolean student;

    private boolean teacher;

    private boolean company;

    private Integer id;

    public List<String> getPurview() {
        List<String> list = new ArrayList<> ();
        list.add ("stu:" + student);
        list.add ("tea:" + teacher);
        list.add ("com:" + company);
        return list;
    }

}