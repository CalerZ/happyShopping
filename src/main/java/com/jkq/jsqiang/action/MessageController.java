package com.jkq.jsqiang.action;

import com.jkq.jsqiang.entity.Message;
import com.jkq.jsqiang.entity.MessageWithBLOBs;
import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caler_赵康乐
 * @create 2020-02-14 10:59
 * @description :
 */
@RequestMapping("/message")
@RestController
public class MessageController {


    @Autowired
    MessageService messageService;


    @GetMapping("/findById")
    public Result findById(Integer id){
        Message msg = messageService.findByPrimaryKey(id);
        return new Result(true,"success",msg,0);

    }

    @PostMapping("add")
    public Result add(String  username,String  name,String  price,String  time,String  Content){

        MessageWithBLOBs message = new MessageWithBLOBs();
        message.setUsername(username);
        message.setFoodname(name);
        message.setBusinesstime(time);
        message.setUsertime(time);
        message.setBusinesscontent(Content);
        message.setUsercontent(Content);

        messageService.add(message);

        return new Result(true,"success",message,0);
    }
}
