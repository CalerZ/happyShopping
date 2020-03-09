package com.jkq.jsqiang.service;

import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.Foods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 13:49
 * @description :
 */
@Service
public interface FoodsService {


    int add(Foods foods);
    List<Foods> selectAll();
    int delete(Integer ids);
    int update(Foods foods);
    PageInfo<Foods> list(Integer pageNum, Integer pageSize);
    Foods selectOne(Integer id);
}
