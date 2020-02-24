package com.jkq.jsqiang.action;

import com.jkq.jsqiang.entity.Foods;
import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.entity.Shopping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caler_赵康乐
 * @create 2020-02-14 22:12
 * @description :
 */
@RestController
public class FoodsController {


    @PostMapping("/findPage")
    public Result findPage(String state, String paisong, String username, Integer page, @RequestParam(name = "num",value = "7") Integer num ){
        Foods foods = new Foods();
        foods.setState(state);

        return  new Result();
    }
}
