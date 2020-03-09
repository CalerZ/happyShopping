package com.jkq.jsqiang.controller;

import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.Foods;
import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.service.FoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-14 22:12
 * @description :
 */
@Api(value = "物品", tags = "物品控制类")
@RestController
public class FoodsController {

    @Autowired
    FoodsService foodsService;

    @ApiOperation(value = "获取商品列表分页",notes = "获取商品列表分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum",value="用户名",required=true),
            @ApiImplicitParam(name="pageSize",value="密码",required=true),
    })
    @PostMapping("/list")
    public Result list(Integer pageNum, Integer pageSize) {
        PageInfo<Foods> info = foodsService.list(pageNum, pageSize);
        return new Result(true,"success", info,0);
    }


    @ApiOperation(value = "获取商品列表",notes = "获取商品列表")
    @ApiImplicitParams({
    })
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Foods> list = foodsService.selectAll();
        return new Result(true,"success", list,0);
    }


    @ApiOperation(value = "根据id查询商品",notes = "根据id查询商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="id",required=true),
    })
    @PostMapping("/selectOne")
    public Result selectAll(Integer id) {
        Foods foods = foodsService.selectOne(id);
        return new Result(true,"success", foods,0);
    }


    @ApiOperation(value = "删除商品",notes = "根据id删除商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="id",required=true),
    })
    @PostMapping("/delete")
    public Result delete(Integer id) {
        foodsService.delete(id);
        return new Result(true,"success", true,0);
    }


    @ApiOperation(value = "添加商品",notes = "添加商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="foods",value="商品属性json数据",required=true),
    })
    @PostMapping("/add")
    public Result add(@RequestBody Foods foods) {
        foodsService.add(foods);
        return new Result(true,"success", foods,0);
    }

    @ApiOperation(value = "编辑商品",notes = "根据id编辑商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name="foods",value="商品属性json数据",required=true),
    })
    @PostMapping("/update")
    public Result update(@RequestBody Foods foods) {
        foodsService.update(foods);
        return new Result(true,"success", foods,0);
    }


}
