package com.life.Mapper;

import com.life.POJO.Resources;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourcesMapper {
    int deleteByPrimaryKey(String number);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);

    List<Resources> selectAll();

    Resources selectByID(int ID);
}