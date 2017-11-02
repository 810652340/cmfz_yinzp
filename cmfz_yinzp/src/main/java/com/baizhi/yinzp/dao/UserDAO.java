package com.baizhi.yinzp.dao;

import com.baizhi.yinzp.entity.CityFB;
import com.baizhi.yinzp.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface UserDAO {
//    查询所有用户
    public List<User> queryAll();
//    修改用户的状态
    public void update(User user);
//    添加一个用户
    public void save(User user);
//    查看一周的活跃量
    public Integer queryAc(Integer num);
//    查看用户分布
    public List<CityFB> queryCity();

}
