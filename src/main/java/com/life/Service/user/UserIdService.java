package com.life.Service.user;

import com.life.POJO.user.UserId;
import org.apache.ibatis.annotations.Param;

public interface UserIdService {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("number") String number);

    int insert(UserId record);

    int insertSelective(UserId record);

    UserId selectById(@Param("id") Integer id, @Param("number") String number);


    Integer maxID();

    int resetAutoIncrementID(@Param("id") Integer id);
}
