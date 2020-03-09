package com.jkq.jsqiang.controller;

import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.Foods;
import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.entity.Shopping;
import com.jkq.jsqiang.service.ShoppingService;
import com.jkq.jsqiang.util.Utils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-13 22:00
 * @description :购物车
 */
@Api(value = "购物车", tags = "购物车控制类")
@RequestMapping("/shopping")
@RestController
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;


    @ApiOperation(value = "查询购物车根据民称", notes = "查询购物车根据民称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true)
    })
    @ApiResponse(code = 0, message = "List<Shopping>", response = Result.class)
    @PostMapping("/findByName")
    public Result findByName(String name) {
        List<Shopping> shoppings = shoppingService.findByName(name);
        return new Result(true, "success", shoppings, 0);
    }

    @ApiOperation(value = "根据ID查询购物车", notes = "根据ID查询购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true)
    })
    @ApiResponse(code = 0, message = "List<Shopping>", response = Result.class)
    @PostMapping("/findById")
    public Result findByPrimaryKey(Integer id) {
        Shopping shopping = shoppingService.findByPrimaryKey(id);
        return new Result(true, "success", shopping, 0);
    }

    @ApiOperation(value = "增加购物车", notes = "增加购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "userName", required = true),
            @ApiImplicitParam(name = "name", value = "name", required = true),
            @ApiImplicitParam(name = "price", value = "price", required = true),
            @ApiImplicitParam(name = "num", value = "num", required = true),
            @ApiImplicitParam(name = "time", value = "time", required = true),
            @ApiImplicitParam(name = "address", value = "address", required = true),
            @ApiImplicitParam(name = "phone", value = "phone", required = true)
    })
    @ApiResponse(code = 0, message = "Result", response = Result.class)
    @PostMapping("/add")
    public Result add(String userName, String name, String price, String num, String time, String address, String phone) {
        try {
            Shopping shopping = new Shopping();
            shopping.setUsername(userName);
            shopping.setPrice(Double.parseDouble(price));
            shopping.setNum(Integer.parseInt(num));
            shopping.setTime(Utils.getDateTime2String(time));
            shopping.setAddress(address);
            shopping.setPhone(phone);

            shoppingService.add(shopping);
            return new Result(true, "success", true, 0);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(false, "添加异常" + e.getMessage(), false, 201);
        }
    }


    //购物车商品根据条件查询
    @ApiOperation(value = "购物车商品根据条件查询", notes = "购物车商品根据条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "购买状态", required = true),
            @ApiImplicitParam(name = "paisong", value = "返货情况", required = true),
            @ApiImplicitParam(name = "username", value = "用户", required = true),
            @ApiImplicitParam(name = "page", value = "当前页吗", required = true),
            @ApiImplicitParam(name = "num", value = "每页行数", required = true)
    })
    @ApiResponse(code = 0, message = "PageInfo<Shopping>", response = Result.class)
    @PostMapping("/findShoppingByCon")
    public Result findShoppingByCon(String state, String paisong, String username, Integer page, Integer num, String address, String phone) {
        try {
            Shopping shopping = new Shopping();
            shopping.setUsername(username);
            shopping.setFoodsstatus(state);
            shopping.setAddress(address);
            shopping.setPhone(phone);
            shopping.setTransportstatus(paisong);

            PageInfo<Shopping> info = shoppingService.findByCont(shopping, page, num);
            return new Result(true, "success", info, 0);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(false, "添加异常" + e.getMessage(), false, 201);
        }
    }

    //购物车商品根据条件查询
    @ApiOperation(value = "查询所以已购买的商品", notes = "查询所以已购买的商品")
    @ApiImplicitParams({
    })
    @ApiResponse(code = 0, message = "PageInfo<Shopping>", response = Result.class)
    @GetMapping("/selectShopping")
    public Result selectShopping(Integer pageNum, Integer pageSize) {
        try {

            PageInfo<Shopping> info = shoppingService.selectShopping(pageNum, pageSize);
            return new Result(true, "success", info, 0);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(false, "添加异常" + e.getMessage(), false, 201);
        }
    }

    //购物车商品根据条件查询
    @ApiOperation(value = "修改购买商品的状态", notes = "修改购买商品的状态")
    @ApiImplicitParams({
    })
    @ApiResponse(code = 0, message = "PageInfo<Shopping>", response = Result.class)
    @PostMapping("/update")
    public Result update(Integer id, String status) {
        try {
            Shopping shopping = new Shopping();
            shopping.setId(id);
            shopping.setFoodsstatus(status);

            shoppingService.update(shopping);
            return new Result(true, "success", true, 0);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new Result(false, "添加异常" + e.getMessage(), false, 201);
        }
    }

    @ApiOperation(value = "购买商品",notes = "购买商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="id",required=true),
    })
    @PostMapping("/buy")
    public Result buy(@RequestBody Shopping shopping) {
        shoppingService.add(shopping);
        return new Result(true,"success", shopping,0);
    }

}
