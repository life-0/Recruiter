package com.life;

import com.life.POJO.Resources;
import com.life.Service.ResourcesServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 *@Author: life-0
 *@ClassName: test_resource
 *@Date: 2021/2/21 14:59
 *TODO @Description:

 */
@SpringBootTest
public class test_resource {
    @Autowired
    private ResourcesServiceImpl resourcesService;

    @Test
    public void queryByID(){
        Resources resources = resourcesService.selectByID (2);
        System.out.println (resources.getPurview ());
        System.out.println (resources);
    }
}
