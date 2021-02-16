package com.life.Service.RoleService;

import com.life.POJO.test.Student;

import java.util.List;

public interface StudentService {
    //增加学生
    int AddStudent(Student student);
    //删除学生
    int DelStudent(String ID);
    //修改学生信息
    int UpdStudent(Student student);
    //得到所有学生信息
    List<Student> studentList();
    //得到特定学生信息
    Student getStudent(String ID);
}
