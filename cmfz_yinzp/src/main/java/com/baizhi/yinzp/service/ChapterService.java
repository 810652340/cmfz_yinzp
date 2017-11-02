package com.baizhi.yinzp.service;

import com.baizhi.yinzp.entity.Album;
import com.baizhi.yinzp.entity.Chapter;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface ChapterService {
//    查看所有的音频
    public List<Chapter> queryAll();
//    删除所有的音频
    public void delAll();
//    添加一个音频文件
    public void save(Chapter chapter);
//    修改音频的状态
    public void update(Chapter chapter);
}
