package com.jkq.jsqiang.service;

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
    int delete(Integer ids);
    User update(User foods);

    boolean findByName(String name);

    User findByPrimaryKey(Integer id);
}
