package com.jkq.jsqiang.action;

import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.entity.Shopping;
import com.jkq.jsqiang.service.ShoppingService;
import com.jkq.jsqiang.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-13 22:00
 * @description :购物车
 */
@RequestMapping("/shopping")
@RestController
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    /**
     * 15，购物车详情
     * @param name
     * @return
     */
    @GetMapping("/findByName")
    public Result findByName(String name) {
        List<Shopping> shoppings = shoppingService.findByName(name);
        return new Result(true, "success", shoppings, 0);
    }

    /**
     * 购物车详情c1
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public Result findByPrimaryKey(Integer id) {
        Shopping shopping = shoppingService.findByPrimaryKey(id);
        return new Result(true, "success", shopping, 0);
    }


    @PostMapping("/add")
    public Result add(String userName,String name,String price,String num,String time,String address,String phone){
        try {
            Shopping shopping = new Shopping();
            shopping.setUsername(userName);
            shopping.setPrice( Double.parseDouble(price) );
            shopping.setNum( Integer.parseInt(num) );
            shopping.setTime(Utils.getDateTime2String(time) );
            shopping.setAddress(address);
            shopping.setPhone(phone);

            shoppingService.add(shopping);
            return new Result(true,"success",true,0);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(false,"添加异常"+e.getMessage(),false,201);
        }


    }




}
