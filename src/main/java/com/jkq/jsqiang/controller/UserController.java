package com.jkq.jsqiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jkq.jsqiang.entity.Result;
import com.jkq.jsqiang.entity.User;
import com.jkq.jsqiang.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 18:59
 * @description :
 */
@Api(value = "用户操作接口",tags="用户类控制器")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户注册",notes = "用户注册")
    @ApiImplicitParams({
                    @ApiImplicitParam(name="name",value="用户名",required=true),
                    @ApiImplicitParam(name="password",value="密码",required=true),
                    @ApiImplicitParam(name="sureword",value="sureword",required=false),
                    @ApiImplicitParam(name="email",value="邮箱",required=false)
            }
    )
    @PostMapping("/register")
    public Result register( String name, String password, String  sureword, String email){
        User user = new User();
        user.setUsername(name);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setEmail(email);

        //name唯一
        if(name==null || "".equals(name)){
            return new Result(false,"姓名不能为空", user,102);
        }
        List<User> userList = userService.findByName(name);
        if(userList.size()>0){
            return new Result(false,"姓名已存在", user,101);
        }
        userService.add(user);
        return new Result(true,"success", user,0);
    }


    @ApiOperation(value = "根据名字查询人员",notes = "根据名字查询人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="用户名",required=true)
    })
    @PostMapping("/findByName")
    public Result findByName(String name){
        List<User> userList = userService.findByName(name);
        return new Result(true,"success", userList,0);
    }


    @ApiOperation(value = "根据id查询人员",notes = "根据名字查询人员,返回user对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="人员id",required=true)
    })
    @ApiResponse(code = 0, message = "user", response = Result.class)
    @PostMapping("/findById")
    public Result findByName(Integer id){
        User user = userService.findByPrimaryKey(id);
        return new Result(true,"success", user,0);
    }

    @ApiOperation(value = "人员分页查询",notes = "人员分页查询")
    @ApiImplicitParams({
    })
    @ApiResponse(code = 0, message = "userPageInfo", response = Result.class)
    @GetMapping("/findAll")
    public Result selectAll(){
        List<User> users = userService.selectAll();
        return new Result(true,"success", users,0);
    }

    @ApiOperation(value = "更新人员",notes = "根据id更新人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="人员id",required=true),
            @ApiImplicitParam(name="username",value="人员姓名",required=true),
            @ApiImplicitParam(name="password",value="密码",required=true),
            @ApiImplicitParam(name="email",value="邮件",required=false),
            @ApiImplicitParam(name="phone",value="手机号",required=false),
            @ApiImplicitParam(name="address",value="地址",required=false),
            @ApiImplicitParam(name="describe",value="描述",required=false),
    })
    @ApiResponse(code = 0, message = "user", response = Result.class)
    @PostMapping("/update")
    public Result update(Integer id,String username,String password,String email,String phone,String address,String describe){
        User user = userService.findByPrimaryKey(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setDescription(describe);
        userService.update(user);
        return new Result(true,"success", user,0);
    }

    @ApiOperation(value = "更新金额",notes = "根据id更新人员金额")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="人员id",required=true),
            @ApiImplicitParam(name="money",value="金额",required=true)

    })
    @ApiResponse(code = 0, message = "boolean", response = Result.class)
    @PostMapping("/recharge")
    public Result recharge(Integer id,String money){
        User user = new User();
        user.setUserid(id);
        user.setMoney(Integer.getInteger(money));
        userService.update(user);
        return new Result(true,"修改成功",true,0);
    }

    @ApiOperation(value = "获取所有用户列表",notes = "获取所有用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum",value="页码",required=true),
            @ApiImplicitParam(name="pageSize",value="行数",required=true),
    })
    @ApiResponse(code = 0, message = "PageInfo<User> info", response = Result.class)
    @PostMapping("/list")
    public Result list(Integer pageNum,Integer pageSize){
        PageInfo<User> info = userService.list(pageNum,pageSize);
        return new Result(true,"success", info,0);
    }

    @ApiOperation(value = "添加用户",notes = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="用户名",required=true),
            @ApiImplicitParam(name="password",value="密码",required=true),
            @ApiImplicitParam(name="eamil",value="邮件",required=true),
            @ApiImplicitParam(name="address",value="地址",required=true),
            @ApiImplicitParam(name="phone",value="手机",required=true),
            @ApiImplicitParam(name="describe",value="描述",required=true),
            @ApiImplicitParam(name="isManager",value="管理",required=true),
    })
    @ApiResponse(code = 0, message = "PageInfo<User> info", response = Result.class)
    @PostMapping("/add")
    public Result list(String name,String password, String eamil,String address,String phone,
                       String describe,String isManager){
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(eamil);
        user.setAddress(address);
        user.setPhone(phone);
        user.setDescription(describe);
        user.setIsmanager(Integer.parseInt(isManager) );
        userService.add(user);
        return new Result(true,"success", user,0);
    }

    @ApiOperation(value = "删除用户",notes = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids",value="用户id",required=true),
    })
    @ApiResponse(code = 0, message = "boolean", response = Result.class)
    @PostMapping("/delete")
    public Result delete(String ids){
        boolean delete = userService.delete(ids);
        return new Result(true,"success", delete,0);
    }

}
