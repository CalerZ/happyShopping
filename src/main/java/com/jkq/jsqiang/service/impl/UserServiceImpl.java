package com.jkq.jsqiang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.User;
import com.jkq.jsqiang.entity.UserExample;
import com.jkq.jsqiang.mapper.UserMapper;
import com.jkq.jsqiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 13:49
 * @description :
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
//    @CachePut(cacheNames ="user",key= "'user_'+#result.userid")
    public User add(User user) {
        userMapper.insertSelective(user);
        return user;
    }

    @Override
    public List<User> selectAll() {

        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public boolean delete(String id) {
        int i = userMapper.deleteByPrimaryKey( Integer.parseInt(id) );
        return true;
    }

    @Override
    public PageInfo<User> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(1,10);
        List<User> users = userMapper.selectByExample(new UserExample());
        PageInfo<User> info = new PageInfo<>(users);

        return info;
    }



    @Override
    @CachePut(cacheNames ="user", key= "'user_'+#result.userid")
    public User update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return user;

    }

    @Override
    public List<User> findByName(String name) {
        boolean isExist=false;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike("%"+name+"%");
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    @CachePut(cacheNames ="user",key= "'user_'+#id")
    public User findByPrimaryKey(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }


}
