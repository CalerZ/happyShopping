package com.jkq.jsqiang.service.impl;

import com.jkq.jsqiang.entity.User;
import com.jkq.jsqiang.entity.UserExample;
import com.jkq.jsqiang.mapper.UserMapper;
import com.jkq.jsqiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
//    @Cacheable(cacheNames ="user",key= "'user_'+#result.userid")
    public User add(User user) {
        userMapper.insertSelectiveForUser(user);
        return user;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
//    @CacheEvict(cacheNames ="user",beforeInvocation = true,key= "'user_'+#id")
    public int delete(Integer id) {
        return 0;
    }

    @Override
//    @CachePut(cacheNames ="user", key= "'user_'+#result.userid")
    public User update(User user) {

        userMapper.updateByPrimaryKeySelective(user);
        return user;

    }

    @Override
    public boolean findByName(String name) {
        boolean isExist=false;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()>0){
            isExist=true;
        }

        return isExist;
    }

    @Override
//    @Cacheable(cacheNames ="user",key= "'user_'+#result.userid")
    public User findByPrimaryKey(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }


}
