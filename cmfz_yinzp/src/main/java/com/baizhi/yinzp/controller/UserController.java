package com.baizhi.yinzp.controller;

import com.baizhi.yinzp.entity.CityFB;
import com.baizhi.yinzp.entity.User;
import com.baizhi.yinzp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//    显示所有
    @RequestMapping("/all")
    @ResponseBody
    public List<User> queryAll(){
        System.out.println("的确，是你错了");
        List<User> users = userService.queryAll();
        return users;
    }
//    修改用户的状态
    @RequestMapping("/update")

    public void update(@RequestBody User user){

        userService.update(user);
    }
//    查看用户的活跃状况
    @RequestMapping("/ac")
    @ResponseBody
    public List<Integer> queryAc(){
        List<Integer> list = new ArrayList<Integer>();
        Integer integer = userService.queryAc(1);
        Integer integer1 = userService.queryAc(2);
        Integer integer2 = userService.queryAc(3);
        list.add(integer);
        list.add(integer1);
        list.add(integer2);
        return list;
    }
    @RequestMapping("/city")
    @ResponseBody
    public List<CityFB> queryCity(){
        List<CityFB> cityFBS = userService.queryCity();
        return cityFBS;
    }
}
