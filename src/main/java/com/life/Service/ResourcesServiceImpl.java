package com.life.Service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.POJO.Resources;
import com.life.Mapper.ResourcesMapper;
import com.life.Service.ResourcesService;

import java.util.List;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Resource
    private ResourcesMapper resourcesMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return resourcesMapper.deleteByPrimaryKey (number);
    }

    @Override
    public int insert(Resources record) {
        return resourcesMapper.insert (record);
    }

    @Override
    public int insertSelective(Resources record) {
        return resourcesMapper.insertSelective (record);
    }

    @Override
    public Resources selectByPrimaryKey(String number) {
        return resourcesMapper.selectByPrimaryKey (number);
    }

    @Override
    public int updateByPrimaryKeySelective(Resources record) {
        return resourcesMapper.updateByPrimaryKeySelective (record);
    }

    @Override
    public int updateByPrimaryKey(Resources record) {
        return resourcesMapper.updateByPrimaryKey (record);
    }

    @Override
    public List<Resources> selectAll() {
        return resourcesMapper.selectAll ();
    }

    @Override
    public Resources selectByID(int ID) {
        return resourcesMapper.selectByID (ID);
    }

}
