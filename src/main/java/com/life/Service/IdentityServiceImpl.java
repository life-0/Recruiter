package com.life.Service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.life.Mapper.IdentityMapper;
import com.life.POJO.Identity;
import com.life.Service.IdentityService;

import java.util.List;

@Service
public class IdentityServiceImpl implements IdentityService {

    @Resource
    private IdentityMapper identityMapper;

    @Override
    public int deleteByPrimaryKey(String number) {
        return identityMapper.deleteByPrimaryKey (number);
    }

    @Override
    public int insert(Identity record) {
        return identityMapper.insert (record);
    }

    @Override
    public int insertSelective(Identity record) {
        return identityMapper.insertSelective (record);
    }

    @Override
    public Identity selectByPrimaryKey(String number) {
        return identityMapper.selectByPrimaryKey (number);
    }

    @Override
    public int updateByPrimaryKeySelective(Identity record) {
        return identityMapper.updateByPrimaryKeySelective (record);
    }

    @Override
    public int updateByPrimaryKey(Identity record) {
        return identityMapper.updateByPrimaryKey (record);
    }

    @Override
    public List<Identity> selectByName(String name) {
        return identityMapper.selectByName (name);
    }

    @Override
    public List<Identity> queryAll() {
        return identityMapper.queryAll ();
    }

}
