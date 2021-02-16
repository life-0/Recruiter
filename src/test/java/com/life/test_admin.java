package com.life;

import com.life.POJO.test.Admin;
import com.life.Service.RoleService.AdminServiceImpl;
import com.life.Utils.NumberUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/*
 *@Author life-0
 *@ClassName test_admin
 *@Date 2020/10/6 10:33
 *@Description: 
 TODO           
*/
@SpringBootTest
public class test_admin {

    @Autowired
    AdminServiceImpl adminService;
    @Test
    void adminLists(){
        List<Admin> admins = adminService.AdminList ();
        for (Admin admin : admins) {
            System.out.println (admin.toString ());
        }

    }
    @Test
    void getadmins(){
        Admin admin = adminService.getAdmin (1);
        System.out.println (admin.toString ());
    }

    @Test
    void addAdmin(){
        Admin admin = new Admin (1,"123456894848","6554","王五 ","12345688@qq.com",
                new NumberUtil ().getRandomNumber (),"");
        adminService.AddAdmin (admin);
        List<Admin> admins = adminService.AdminList ();
        for (Admin adminer : admins) {
            System.out.println (adminer.toString ());
        }
    }
    @Test
    void DeleteAdmin(){
        adminService.DelAdmin (1);
        List<Admin> admins = adminService.AdminList ();
        for (Admin adminer : admins) {
            System.out.println (adminer.toString ());
        }
    }
    @Test
    void Update(){
        Admin admin = new Admin (2,"123456865","6546","8484 ","12345688@qq.com",
                new NumberUtil ().getRandomNumber (),"");
        adminService.UpdAdmin (admin);
        List<Admin> admins = adminService.AdminList ();
        for (Admin adminer : admins) {
            System.out.println (adminer.toString ());
        }
    }
}
