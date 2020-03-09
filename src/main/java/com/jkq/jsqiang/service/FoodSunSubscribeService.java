package com.jkq.jsqiang.service;

import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.FoodSunSubscribe;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-03-09 14:04
 * @description :
 */
public interface FoodSunSubscribeService {

    FoodSunSubscribe add(FoodSunSubscribe user);
    List<FoodSunSubscribe> selectAll();
    PageInfo<FoodSunSubscribe> list(FoodSunSubscribe foodSunSubscribe, int pageNum, int pageSize);
    int delete(Integer ids);
    FoodSunSubscribe update(FoodSunSubscribe foodSunSubscribe);
    boolean findByName(String name);
    FoodSunSubscribe findByPrimaryKey(Integer id);
}
