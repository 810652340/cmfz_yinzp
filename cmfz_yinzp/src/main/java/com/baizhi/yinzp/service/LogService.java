package com.baizhi.yinzp.service;

import com.baizhi.yinzp.entity.Log;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
public interface LogService{
//    保存一条数据
    public void save(Log log);
//    查询所有数据
    public List<Log> queryAll();
}
