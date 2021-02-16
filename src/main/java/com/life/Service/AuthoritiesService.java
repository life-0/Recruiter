package com.life.Service;

import com.life.POJO.Authorities;

import java.util.List;

public interface AuthoritiesService {

    int deleteByPrimaryKey(String number);

    int insert(Authorities record);

    int insertSelective(Authorities record);

    Authorities selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(Authorities record);

    int updateByPrimaryKey(Authorities record); //根据number更新权限信息

    List<Authorities> query_all();  // 查询所有权限

    List<Authorities> query_name(String name);  //查询权限名
}
