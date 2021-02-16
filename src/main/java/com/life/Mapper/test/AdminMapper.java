package com.life.Mapper.test;

import com.life.POJO.test.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *@Author life-0
 *@ClassName AdminMapper
 *@Date 2020/10/5 11:56
 *@Description: 
 TODO           
*/
@Repository
@Mapper
public interface AdminMapper {
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
