package com.ljd.food_support_sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ljd.food_support_sys.entity.User;
import com.ljd.food_support_sys.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin//允许跨域
public class UserController {
    @Autowired
    UserMapper userMapper;

    //用户登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public User login(@RequestBody User user){
        if (user.getUserName()==null || user.getPassword()==null){
            throw new RuntimeException("参数错误");
        }
        User result=userMapper.login(user.getUserName(),user.getPassword());
        if (result==null){
            throw new RuntimeException("用户名或密码错误！");
        } //else if(result!=null){
//            userMapper.userType(user.getUserName());
//        }
        return result;
    }


    //查询所有用户（已测）
    @RequestMapping("getAllUser")
    public Map getAllUser(){
        Map<String,Object> result=new HashMap<>();
        List<User> userlist = userMapper.selectList(null);
        if (userlist==null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code",200);
            result.put("data",userlist);
            result.put("msg","查询所有成功");
            return result;
        }

    }
    //查询单条用户（已测）
    @RequestMapping("getUserById")
    public Map getUserById(@RequestBody User user){
        Map<String,Object> result=new HashMap<>();
        User u =userMapper.selectById(user.getUserId());
        if ( u == null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code","200");
            result.put("data", u);
            result.put("msg","单条用户查询成功");
            return result;
        }
    }
    //根据名字查询单条用户
    @RequestMapping("getUserByRealName")
    public Map getUserByRealName(@RequestBody User user){
        Map<String,Object> result=new HashMap<>();
        QueryWrapper<User> userQueryWrapper= Wrappers.query();
        userQueryWrapper.like("real_name",user.getRealName());
        User u =userMapper.selectOne(userQueryWrapper);
        if ( u == null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code","200");
            result.put("data", u);
            result.put("msg","单条用户查询成功");
            return result;
        }
    }

    //查询所有用户数量（已测）
    @RequestMapping("getUserCount")
    public Map getUserCount(){
        Map<String,Object> result=new HashMap<>();
        //List<User> users = userMapper.selectList(null);
        Integer i = userMapper.selectCount(null);
        if (i>=1){
            result.put("code",200);
            result.put("data",i);
            result.put("msg","查询用户成功");
            return result;
        }
        else {
            result.put("code",200);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }

    }
    //添加用户信息（已测）
    @RequestMapping("/addUser")
    public Map addUser(@RequestBody User user){
        int i = userMapper.insert(user);
        Map<String,Object> result=new HashMap<>();
        if(i>=1){
            result.put("code",200);
            result.put("data",user);
            result.put("msg","添加用户成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data","");
            result.put("msg","添加失败");
            return result;
        }
    }
    //修改用户信息（已测）
    @RequestMapping("updateUserById")
    public Map updateUserById(@RequestBody User user){
        int i = userMapper.updateById(user);
        Map<String,Object> result=new HashMap<>();
        if(i>=1){
            result.put("code",200);
            result.put("data",user);
            result.put("msg","修改成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data","");
            result.put("msg","修改失败");
            return result;
        }
    }
    //根据Id删除用户（已测）
    @RequestMapping("deleteUserById")
    public Map deleteUserById(@RequestBody User user){
        Map<String,Object> result=new HashMap<>();
        int i = userMapper.deleteById(user.getUserId());
        if (i==0){
            result.put("code",200);
            result.put("data",user.getUserId());
            result.put("msg","已删除");
            return result;
        }else {
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","出错了！");
            return result;
        }
    }
//
//    @RequestMapping("getUserRole")
//    public List<User> getUserRole(Integer userId){
//        UserMapper mapper = this.userMapper;
//        if (userId!=null){
//            return mapper.getUserRole(userId);
//        }else {
//            return mapper.getUserRole(userId);
//        }
//        return mapper.getUserRole(userId);
//    }

}
