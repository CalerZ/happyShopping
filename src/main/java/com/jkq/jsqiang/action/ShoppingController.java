package com.jkq.jsqiang.action;

import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.entity.Shopping;
import com.jkq.jsqiang.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-13 22:00
 * @description :
 */
@RequestMapping("/shopping")
@RestController
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    @GetMapping("/findByName")
    public Result findByName(String name) {
        List<Shopping> shoppings = shoppingService.findByName(name);
        return new Result(true, "success", shoppings, 0);
    }

    @GetMapping("/findById")
    public Result findByPrimaryKey(Integer id) {
        Shopping shopping = shoppingService.findByPrimaryKey(id);
        return new Result(true, "success", shopping, 0);
    }

}
