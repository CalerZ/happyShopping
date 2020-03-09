package com.jkq.jsqiang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        int i = shoppingMapper.updateByPrimaryKey(shopping);
        return i;
    }

    @Override
    public List<Shopping>  findByName(String name) {
        ShoppingExample example = new ShoppingExample();
        ShoppingExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<Shopping> shoppings = shoppingMapper.selectByExample(example);
        return shoppings;
    }

    @Override
    public PageInfo<Shopping> findByCont(Shopping shopping, int pageNum, int pageSize) {
        ShoppingExample shoppingExample = new ShoppingExample();
        shoppingExample.createCriteria().andUsernameEqualTo(shopping.getUsername())
                                        .andFoodsstatusEqualTo(shopping.getFoodsstatus())
                                        .andPhoneLike("%"+shopping.getPhone()+"%")
                                        .andTransportstatusEqualTo(shopping.getTransportstatus());
        PageHelper.startPage(pageNum,pageSize);
        List<Shopping> shoppings = shoppingMapper.selectByExample(shoppingExample);
        PageInfo<Shopping> info = new PageInfo<>(shoppings);
        return info;
    }

    @Override
    public PageInfo<Shopping> selectShopping(Integer pageNum, Integer pageSize) {
        ShoppingExample shoppingExample = new ShoppingExample();
        shoppingExample.createCriteria().andFoodsstatusEqualTo("已购买");

        PageHelper.startPage(pageNum,pageSize);
        List<Shopping> shoppings = shoppingMapper.selectByExample(shoppingExample);
        PageInfo<Shopping> info = new PageInfo<>(shoppings);
        return info;
    }

    @Override
    public Shopping findByPrimaryKey(Integer id) {
        return shoppingMapper.selectByPrimaryKey(id);

    }
}
