package com.life.Service.RoleService;

import com.life.POJO.test.RoleList;

import java.util.List;

public interface RoleService  {
    int queryCount_Role(int id);
    void addRole();
    void delRole();
    void updRole();
    List<RoleList> queryRoleAll();
}
