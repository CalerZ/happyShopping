package com.jkq.jsqiang.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-01-19 15:49
 * @description :
 */


@RestController
public class TestAction {


    @GetMapping("/hello")
    public String  hello(){
        return "hello";
    }


}
