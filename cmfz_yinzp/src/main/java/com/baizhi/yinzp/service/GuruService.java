package com.baizhi.yinzp.service;

import com.baizhi.yinzp.entity.Guru;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface GuruService {
    //    查看所有的上师
    public List<Guru> queryAll();
    //    添加一个上师
    public void save(Guru guru);
    //    修改上师的状态
    public void update(Guru guru);
//    查询该上师的所有文章
    public List<Guru> queryOne();
}
