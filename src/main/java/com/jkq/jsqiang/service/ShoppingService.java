package com.jkq.jsqiang.service;

import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.Shopping;
import com.jkq.jsqiang.entity.User;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 13:49
 * @description :
 */

public interface ShoppingService {


    int add(Shopping shopping);
    List<Shopping> selectAll();
    int delete(Integer id);
    int update(Shopping shopping);

    Shopping findByPrimaryKey(Integer id);
    List<Shopping> findByName(String name);
    PageInfo<Shopping> findByCont(Shopping shopping, int pageNum, int pageSize);
    PageInfo<Shopping> selectShopping(Integer pageNum, Integer pageSize);
}
