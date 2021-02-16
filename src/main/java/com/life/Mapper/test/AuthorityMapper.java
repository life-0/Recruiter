package com.life.Mapper.test;

import com.life.POJO.test.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *@Author: life-0
 *@ClassName: AuthorityMapper
 *@Date: 2020/12/27 17:25
 *TODO @Description: 权限表的增删改查以及个数统计

 */
@Mapper
public interface AuthorityMapper {

    void addAuthority(String name, String token);    //增加权限

    void delAuthority(String name); //删除权限

    void updAuthority(@Param("name") String name, @Param("token") String token);    //更新权限

    Authority queryAuthority(String name);  //权限查询

    List<Authority> queryAll(); //查看所有权限

    int AuthorityCount();  //权限个数
}
