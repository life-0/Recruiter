package com.life.Mapper.test;

import com.life.POJO.test.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *@Author life-0
 *@ClassName StudentDao
 *@Date 2020/9/23 15:05
 *@Description: 
 TODO           
*/
@Repository
@Mapper
public interface StudentMapper {
    //增加学生
    int AddStudent(Student student);
    //删除学生
    int DelStudent(String ID);
    //修改学生信息
    int UpdStudent(Student student);
    //得到所有学生信息
    List<Student> studentList();
    //得到单个学生的信息
    Student getStudent(String ID);


}
