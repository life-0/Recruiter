package com.life;


import com.life.POJO.test.Student;
import com.life.Service.RoleService.StudentServiceImpl;
import com.life.Utils.NumberUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class Springboot04WebprojectApplicationTests {
    /*@Test
    void contextLoads() {
        EmployeeDao employeeDao = new EmployeeDao();
        System.out.println (employeeDao.getAll ());
    }*/
    @Autowired
    StudentServiceImpl studentService;

    @Test
    void contextLoads() {
        Student student = new Student ("201809602333",'男',"人才", "147192464@qq.com",
                "","2人才3","456789",
                "18874946524",new NumberUtil ().getRandomNumber (),""
                );
        studentService.AddStudent (student);
        List<Student> students = studentService.studentList ();
        for (Student student1 : students) {
            System.out.println (student1.toString ());
        }
    }
    @Test
    void contextLoads_1() {
        int i = studentService.DelStudent ("20180960121");
        System.out.println (i);

    }

    @Test
    void contextLoads_2() {
        Student student = new Student ("20180960121",'女',"五五", "1471925856@qq.com",
                "","李莉莉","456789","1887454544"
                ,new NumberUtil ().getRandomNumber (),"");
        int i = studentService.UpdStudent (student);
        System.out.println (i);

    }

    @Test
    void contextLoads_3() {
        List<Student> students = studentService.studentList ();
        for (Student student : students) {
            System.out.println (student.toString ());
        }
    }

}
