package com.jkq.jsqiang.controller;

import com.jkq.jsqiang.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caler_赵康乐
 * @create 2020-02-13 21:49
 * @description :
 */
@RestController
@RequestMapping("/wui")
public class LoingController {


    @RequestMapping("/login")
    public Result login(String name,String password){

        return new Result();
    }
}
