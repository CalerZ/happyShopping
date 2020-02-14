package com.jkq.jsqiang.service;

import com.jkq.jsqiang.entity.Message;
import com.jkq.jsqiang.entity.MessageWithBLOBs;
import com.jkq.jsqiang.entity.User;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 13:49
 * @description :
 */

public interface MessageService {


    int add(Message message);
    List<Message> selectAll();
    int delete(Integer ids);
    int update(Message message);

    boolean findByName(String name);

    Message findByPrimaryKey(Integer id);

    boolean reply(MessageWithBLOBs message);
}
