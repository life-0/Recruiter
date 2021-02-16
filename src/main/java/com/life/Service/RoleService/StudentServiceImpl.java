package com.life.Service.RoleService;

import com.life.Mapper.test.StudentMapper;
import com.life.POJO.test.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@Author life-0
 *@ClassName StudentService
 *@Date 2020/9/23 15:43
 *@Description: 
 TODO           
*/
@Service
public class StudentServiceImpl implements StudentService {
    //装配Mapper
    @Autowired
    StudentMapper studentMapper;
    @Override
    public int AddStudent(Student student) {
        return studentMapper.AddStudent (student);
    }

    @Override
    public int DelStudent(String ID) {
        return studentMapper.DelStudent (ID);
    }

    @Override
    public int UpdStudent(Student student) {
        return studentMapper.UpdStudent (student);
    }

    @Override
    public List<Student> studentList() {
        return studentMapper.studentList ();
    }

    @Override
    public Student getStudent(String ID) {
        return studentMapper.getStudent (ID);
    }
}
