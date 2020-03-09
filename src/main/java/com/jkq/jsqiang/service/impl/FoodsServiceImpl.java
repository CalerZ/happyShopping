package com.jkq.jsqiang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.Foods;
import com.jkq.jsqiang.entity.FoodsExample;
import com.jkq.jsqiang.mapper.FoodsMapper;
import com.jkq.jsqiang.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 13:49
 * @description :
 */

@Service
public class FoodsServiceImpl implements FoodsService {


    @Autowired
    FoodsMapper foodsMapper;

    @Override
    public int add(Foods foods) {

        int i = foodsMapper.insertSelective(foods);

        return i;
    }

    @Override
    public List<Foods> selectAll() {
        List<Foods> foods = foodsMapper.selectByExample(new FoodsExample());
        return foods;
    }

    @Override
    public int delete(Integer id) {

        return foodsMapper.deleteByPrimaryKey(id);

    }

    @Override
    public int update(Foods foods) {

        return foodsMapper.updateByPrimaryKeySelective(foods);
    }

    @Override
    public PageInfo<Foods> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Foods> foods = foodsMapper.selectByExample(new FoodsExample());
        PageInfo<Foods> info = new PageInfo<>(foods);
        return info;
    }

    @Override
    public Foods selectOne(Integer id) {
        Foods foods = foodsMapper.selectByPrimaryKey(id);
        return foods;
    }
}
