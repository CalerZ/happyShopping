package com.jkq.jsqiang.controller;


import com.jkq.jsqiang.entity.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caler_赵康乐
 * @create 2020-01-19 15:49
 * @description :
 */


@Api(value = "测试类",tags = "测试")
@RestController
public class TestAction {

    @ApiOperation(value = "测试接口",notes = "测试接口")
    @ApiResponse(code = 0, message = "hello", response = Result.class)
    @GetMapping("/hello")
    public String  hello(){
        return "hello";
    }


}
