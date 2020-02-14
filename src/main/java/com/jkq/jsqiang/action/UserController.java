package com.jkq.jsqiang.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.entity.User;
import com.jkq.jsqiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 18:59
 * @description :
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public Result register(String name, String password, String  sureword, String email){
        User user = new User();
        user.setUsername(name);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setEmail(email);

        //name唯一
        if(name==null || "".equals(name)){
            return new Result(false,"姓名不能为空", user,102);
        }
        boolean isExist = userService.findByName(name);
        if(isExist){
            return new Result(false,"姓名已存在", user,101);
        }
        userService.add(user);
        return new Result(true,"success", user,0);
    }

    @GetMapping("/findByName")
    public Result findByName(String name){
        boolean isExist = userService.findByName(name);
        JSONObject res = new JSONObject();
        res.put("isExist",isExist);
        return new Result(true,"success", res,0);
    }

    @GetMapping("/findById")
    public Result findByName(Integer id){
        User user = userService.findByPrimaryKey(id);
        return new Result(true,"success", user,0);
    }

    @GetMapping("/update")
    public Result update(Integer id,String username,String password,String email,String phone,String address,String describe){
        User user = userService.findByPrimaryKey(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setDescribe(describe);
        userService.update(user);
        return new Result(true,"success", user,0);
    }


    @PostMapping("/recharge")
    public Result recharge(Integer id,String money){
        User user = new User();
        user.setUserid(id);
        user.setMoney(Integer.getInteger(money));

        userService.update(user);
        return new Result(true,"修改成功",true,0);
    }



}
