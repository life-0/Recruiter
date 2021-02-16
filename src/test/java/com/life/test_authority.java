package com.life;

import com.life.POJO.Authorities;
import com.life.Service.AuthoritiesServiceImpl;
import com.life.Utils.NumberUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/*
 *@Author: life-0
 *@ClassName: test_authority
 *@Date: 2021/2/6 11:55
 *TODO @Description:

 */
@SpringBootTest
public class test_authority {
    @Autowired
    private AuthoritiesServiceImpl authorityService;

    @Test
    public void query_all() {
        List<Authorities> authorities = authorityService.query_all ();
        for (Authorities authority : authorities) {
            System.out.println (authority);
        }
    }

    @Test
    public void query_name() {
        List<Authorities> authorities = authorityService.query_name ("添加");
        for (Authorities authority : authorities) {
            System.out.println (authority);
        }
    }

    @Test
    public void insertAuthority() {
        NumberUtil numberUtil = new NumberUtil ();
        Authorities authorities = new Authorities (numberUtil.getRandomNumber (),
                "watch", "监视","monitor");
        authorityService.insert (authorities);
    }

}
