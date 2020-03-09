package com.jkq.jsqiang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@EnableAsync
//@EnableWebMvc
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.jkq.jsqiang.mapper")
public class JsqiangApplication {


    public static void main(String[] args) {
        SpringApplication.run(JsqiangApplication.class, args);
    }

}
