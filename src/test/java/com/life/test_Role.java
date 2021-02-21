package com.life;

import com.life.POJO.test.RoleList;
import com.life.Service.RoleService.RoleServiceImpl;
import com.life.Utils.NumberUtil;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/*
 *@Author life-0
 *@ClassName test_Role
 *@Date 2020/12/25 11:24
 *@Description: 
 TODO           
*/
public class test_Role {
    @Resource
    private RoleServiceImpl roleService;
    @Test
    public void queryCount_Role(){
        NumberUtil numberUtil = new NumberUtil ();
        int i=1;
        while (i<10){
            System.out.println (numberUtil.getRandomNumber ());
            i++;
        }
    }

    @Test
    public void test_boolean(){
        List<RoleList> roleLists = roleService.queryRoleAll ();
        System.out.println (roleLists);
    }

}
