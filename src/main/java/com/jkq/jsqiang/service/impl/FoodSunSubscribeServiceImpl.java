package com.jkq.jsqiang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.FoodSunSubscribe;
import com.jkq.jsqiang.entity.FoodSunSubscribeExample;
import com.jkq.jsqiang.mapper.FoodSunSubscribeMapper;
import com.jkq.jsqiang.service.FoodSunSubscribeService;
import com.jkq.jsqiang.service.FoodSunSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 13:49
 * @description :
 */
@Service
public class FoodSunSubscribeServiceImpl implements FoodSunSubscribeService {

    @Autowired
    FoodSunSubscribeMapper foodSunSubscribeMapper;


    @Override
    public FoodSunSubscribe add(FoodSunSubscribe user) {
        return null;
    }

    @Override
    public List<FoodSunSubscribe> selectAll() {
        return null;
    }

    @Override
    public PageInfo<FoodSunSubscribe> list(FoodSunSubscribe foodSunSubscribe, int pageNum, int pageSize) {

        FoodSunSubscribeExample foodSunSubscribeExample = new FoodSunSubscribeExample();
        foodSunSubscribeExample.createCriteria().andUsernameEqualTo(foodSunSubscribe.getUsername());
        PageHelper.startPage(pageNum,pageSize);
        List<FoodSunSubscribe> foodSunSubscribes = foodSunSubscribeMapper.selectByExample(foodSunSubscribeExample);
        PageInfo<FoodSunSubscribe> info = new PageInfo(foodSunSubscribes);
        return info;
    }



    @Override
    public int delete(Integer ids) {
        return 0;
    }

    @Override
    public FoodSunSubscribe update(FoodSunSubscribe foodSunSubscribe) {
        return null;
    }

    @Override
    public boolean findByName(String name) {
        return false;
    }

    @Override
    public FoodSunSubscribe findByPrimaryKey(Integer id) {
        return null;
    }
}
