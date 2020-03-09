package com.jkq.jsqiang.service;

import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.User;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 13:49
 * @description :
 */

public interface UserService {


    User add(User user);
    List<User> selectAll();
    boolean delete(String ids);
    User update(User foods);
    List<User> findByName(String name);
    User findByPrimaryKey(Integer id);
    PageInfo<User> list(Integer pageNum, Integer pageSize);
}
