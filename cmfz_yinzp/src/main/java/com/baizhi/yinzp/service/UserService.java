package com.baizhi.yinzp.service;

import com.baizhi.yinzp.entity.CityFB;
import com.baizhi.yinzp.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface UserService {
    //    查询所有用户
    public List<User> queryAll();
    //    修改用户的状态
    public void update(User user);
    //    添加一个用户
    public void save(User user);
//    查询用户活跃
    public Integer queryAc(Integer num);
//    查看用户所在地
public List<CityFB> queryCity();
}
