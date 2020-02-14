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

import java.util.HashMap;
import java.util.Map;

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


    /**
     * 6.	获取商品评论
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public Result findById(Integer id){
        Message msg = messageService.findByPrimaryKey(id);
        return new Result(true,"success",msg,0);

    }

    /**
     * 7，提交商品评论
     * @param username
     * @param name
     * @param price
     * @param time
     * @param Content
     * @return
     */
    @PostMapping("/add")
    public Result add(String  username,String  name,String  price,String  time,String  Content){

        MessageWithBLOBs message = new MessageWithBLOBs();
        message.setUsername(username);
        message.setFoodname(name);
        message.setUsertime(time);
        message.setUsercontent(Content);

        messageService.add(message);

        return new Result(true,"success",message,0);
    }

    @PostMapping("/reply")
    public Result add(Integer  id,String  time,String  content){

        MessageWithBLOBs message = new MessageWithBLOBs();
        message.setId(id);
        message.setBusinesstime(time);
        message.setBusinesscontent(content);
        boolean b = messageService.reply(message);
        Map map = new HashMap();
        map.put("isReply",b);

        return new Result(true,"success",map,0);
    }
}
