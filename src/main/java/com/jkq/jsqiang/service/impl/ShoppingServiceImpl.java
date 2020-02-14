package com.jkq.jsqiang.service.impl;

import com.jkq.jsqiang.entity.Shopping;
import com.jkq.jsqiang.entity.ShoppingExample;
import com.jkq.jsqiang.entity.User;
import com.jkq.jsqiang.mapper.ShoppingMapper;
import com.jkq.jsqiang.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-13 21:56
 * @description :
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    ShoppingMapper shoppingMapper;


    @Override
    public int add(Shopping shopping) {
        return 0;
    }

    @Override
    public List<Shopping> selectAll() {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(Shopping shopping) {
        return 0;
    }

    @Override
    public List<Shopping>  findByName(String name) {
        ShoppingExample example = new ShoppingExample();
        ShoppingExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike(name);
        List<Shopping> shoppings = shoppingMapper.selectByExample(example);
        return shoppings;
    }

    @Override
    public Shopping findByPrimaryKey(Integer id) {
        return shoppingMapper.selectByPrimaryKey(id);

    }
}
