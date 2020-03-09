package com.jkq.jsqiang.controller;

import com.jkq.jsqiang.entity.FoodSunSubscribe;
import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.service.FoodSunSubscribeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caler_赵康乐
 * @create 2020-03-09 14:08
 * @description :
 */
@Api(value = "商品订单", tags = "商品订单控制器")
@RestController
@RequestMapping("/fss")
public class FoodSunSubscribeController {

    @Autowired
    FoodSunSubscribeService foodSunSubscribeService;


    @ApiOperation(value = "提交商品退订单", notes = "提交商品退订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "username", required = true),
            @ApiImplicitParam(name = "name", value = "商品名称", required = true),
            @ApiImplicitParam(name = "total", value = "单价", required = true),
            @ApiImplicitParam(name = "describe", value = "退回原由", required = true),
            @ApiImplicitParam(name = "num", value = "数量", required = true),
            @ApiImplicitParam(name = "address", value = "商家地址", required = true),
            @ApiImplicitParam(name = "phone", value = "商家手机号", required = true),
            @ApiImplicitParam(name = "time", value = "退货时间", required = true),

    })
    @ApiResponse(code = 0, message = "foodSunSubscribe", response = Result.class)
    @PostMapping("/add")
    public Result add(String username, String name, double total, String describe, Integer num,
                      String address, String phone, String time) {
        try {
            FoodSunSubscribe foodSunSubscribe = new FoodSunSubscribe();
            foodSunSubscribeService.add(foodSunSubscribe);
            return new Result(true, "success", foodSunSubscribe, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "success", e.getMessage(), 0);
        }
    }

    @ApiOperation(value = "获取所有的退货列表", notes = "提交商品退订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "username", required = true),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "行数", required = true),
    })
    @ApiResponse(code = 0, message = "foodSunSubscribe", response = Result.class)
    @PostMapping("/list")
    public Result list(String username, Integer pageNum,Integer pageSize) {
        try {
            FoodSunSubscribe foodSunSubscribe = new FoodSunSubscribe();
            foodSunSubscribe.setUsername(username);
            foodSunSubscribeService.list(foodSunSubscribe,pageNum,pageSize);
            return new Result(true, "success", foodSunSubscribe, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "success", e.getMessage(), 0);
        }
    }
}
