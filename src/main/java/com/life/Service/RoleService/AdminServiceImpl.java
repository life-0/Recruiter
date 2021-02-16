package com.life.Service.RoleService;

import com.life.Mapper.test.AdminMapper;
import com.life.POJO.test.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@Author life-0
 *@ClassName AdminServiceImpl
 *@Date 2020/10/6 10:15
 *@Description: 
 TODO           
*/
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;

    @Override
    public int AddAdmin(Admin admin) {
        return adminMapper.AddAdmin (admin);
    }

    @Override
    public int DelAdmin(int ID) {
        return adminMapper.DelAdmin (ID);
    }

    @Override
    public int UpdAdmin(Admin student) {
        return adminMapper.UpdAdmin (student);
    }

    @Override
    public List<Admin> AdminList() {
        return adminMapper.AdminList ();
    }

    @Override
    public Admin getAdmin(int ID) {
        return adminMapper.getAdmin (ID);
    }
}
