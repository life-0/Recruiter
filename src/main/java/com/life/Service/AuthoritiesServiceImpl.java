package com.life.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.life.Mapper.AuthoritiesMapper;
import com.life.POJO.Authorities;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    @Resource
    private AuthoritiesMapper authoritiesMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return authoritiesMapper.deleteByPrimaryKey (number);
    }

    @Override
    public int insert(Authorities record) {
        return authoritiesMapper.insert (record);
    }

    @Override
    public int insertSelective(Authorities record) {
        return authoritiesMapper.insertSelective (record);
    }

    @Override
    public List<Authorities> query_all() {
        return authoritiesMapper.query_all ();
    }

    @Override
    public List<Authorities> query_name(String name) {
        return authoritiesMapper.query_name (name);
    }

    @Override
    public Authorities selectByPrimaryKey(String number) {
        return authoritiesMapper.selectByPrimaryKey (number);
    }

    @Override
    public int updateByPrimaryKeySelective(Authorities record) {
        return authoritiesMapper.updateByPrimaryKeySelective (record);
    }

    @Override
    public int updateByPrimaryKey(Authorities record) {
        return authoritiesMapper.updateByPrimaryKey (record);
    }

}
