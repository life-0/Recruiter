package com.life.Service.RoleService;

import com.life.POJO.test.Admin;

import java.util.List;

public interface AdminService {
    //增加管理员
    int AddAdmin(Admin admin);
    //删除管理员
    int DelAdmin(int ID);
    //修改管理员
    int UpdAdmin(Admin student);
    //得到所有管理员信息
    List<Admin> AdminList();
    //得到单个管理员的信息
    Admin getAdmin(int ID);
}
