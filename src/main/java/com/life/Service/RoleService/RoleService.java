package com.life.Service.RoleService;

import com.life.POJO.test.Role;

import java.util.List;

public interface RoleService  {
    int queryCount_Role();
    void addRole();
    void delRole();
    void updRole();
    List<Role> queryRole();
}
