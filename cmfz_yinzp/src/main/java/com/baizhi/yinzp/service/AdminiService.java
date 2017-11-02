package com.baizhi.yinzp.service;

import com.baizhi.yinzp.entity.Admini;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface AdminiService {
//    登录
    public Admini queryByName(String name);
//    修改密码
    public void update(Admini admini);

}
