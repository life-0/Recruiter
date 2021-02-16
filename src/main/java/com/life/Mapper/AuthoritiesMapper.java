package com.life.Mapper;

import com.life.POJO.Authorities;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface AuthoritiesMapper {
    int deleteByPrimaryKey(String number);

    int insert(Authorities record);

    int insertSelective(Authorities record);

    Authorities selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(Authorities record);

    int updateByPrimaryKey(Authorities record); //根据number更新权限信息

    List<Authorities> query_all();  // 查询所有权限

    List<Authorities> query_name(String name);  //查询权限名
}