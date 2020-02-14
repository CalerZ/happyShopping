package com.jkq.jsqiang.service.impl;

import com.jkq.jsqiang.entity.Message;
import com.jkq.jsqiang.entity.User;
import com.jkq.jsqiang.mapper.MessageMapper;
import com.jkq.jsqiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-14 10:54
 * @description :
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;
    @Override
    public int add(Message message) {
        return 0;
    }

    @Override
    public List<Message> selectAll() {
        return null;
    }

    @Override
    public int delete(Integer ids) {
        return 0;
    }

    @Override
    public int update(Message message) {
        return 0;
    }

    @Override
    public boolean findByName(String name) {
        return false;
    }

    @Override
    public Message findByPrimaryKey(Integer id) {

        return  messageMapper.selectByPrimaryKey(id);
    }
}
