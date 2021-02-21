package com.life.Service.RoleService;

import com.life.Mapper.test.RoleMapper;
import com.life.POJO.test.RoleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@Author life-0
 *@ClassName RoleServiceImpl
 *@Date 2020/12/25 11:30
 *@Description: 
 TODO           
*/
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int queryCount_Role(int id) {
        return roleMapper.queryCount_Role (id);
    }



    @Override
    public void addRole() {

    }

    @Override
    public void delRole() {

    }

    @Override
    public void updRole() {

    }

    @Override
    public List<RoleList> queryRoleAll() {
        return roleMapper.getAllRole ();
    }

}
