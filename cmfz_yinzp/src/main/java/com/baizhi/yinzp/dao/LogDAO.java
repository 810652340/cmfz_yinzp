package com.baizhi.yinzp.dao;

import com.baizhi.yinzp.entity.Log;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface LogDAO {
//    添加一条数据
    public void save(Log log);
//    查询所有数据
    public List<Log> queryAll();

}
