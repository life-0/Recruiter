package com.life.Service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.life.Mapper.UserAuthorityMapper;
import com.life.POJO.UserAuthority;
import com.life.Service.UserAuthorityService;
@Service
public class UserAuthorityServiceImpl implements UserAuthorityService{

    @Resource
    private UserAuthorityMapper userAuthorityMapper;

    @Override
    public int deleteByPrimaryKey(String token,String id) {
        return userAuthorityMapper.deleteByPrimaryKey(token,id);
    }

    @Override
    public int insert(UserAuthority record) {
        return userAuthorityMapper.insert(record);
    }

    @Override
    public int insertSelective(UserAuthority record) {
        return userAuthorityMapper.insertSelective(record);
    }

    @Override
    public UserAuthority selectByPrimaryKey(String token,String id) {
        return userAuthorityMapper.selectByPrimaryKey(token,id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserAuthority record) {
        return userAuthorityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserAuthority record) {
        return userAuthorityMapper.updateByPrimaryKey(record);
    }

}
