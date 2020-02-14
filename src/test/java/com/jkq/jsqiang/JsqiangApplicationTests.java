package com.jkq.jsqiang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class JsqiangApplicationTests {

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        Object druidDataSource1 = ioc.getBean("druidDataSource");

        boolean druidDataSource = ioc.containsBean("druidDataSource");
        System.out.println(druidDataSource);
    }

}
