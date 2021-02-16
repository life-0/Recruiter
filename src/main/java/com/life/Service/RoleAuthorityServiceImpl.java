package com.life.Service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.Mapper.RoleAuthorityMapper;
import com.life.POJO.RoleAuthority;
import com.life.Service.RoleAuthorityService;
@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService{

    @Resource
    private RoleAuthorityMapper roleAuthorityMapper;

    @Override
    public int deleteByPrimaryKey(String token,String id) {
        return roleAuthorityMapper.deleteByPrimaryKey(token,id);
    }

    @Override
    public int insert(RoleAuthority record) {
        return roleAuthorityMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleAuthority record) {
        return roleAuthorityMapper.insertSelective(record);
    }

    @Override
    public RoleAuthority selectByPrimaryKey(String token,String id) {
        return roleAuthorityMapper.selectByPrimaryKey(token,id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleAuthority record) {
        return roleAuthorityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleAuthority record) {
        return roleAuthorityMapper.updateByPrimaryKey(record);
    }

}
