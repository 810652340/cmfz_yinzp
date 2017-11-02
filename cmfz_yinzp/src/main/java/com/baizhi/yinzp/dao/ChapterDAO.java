package com.baizhi.yinzp.dao;

import com.baizhi.yinzp.entity.Chapter;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface ChapterDAO {
//    查看该专辑的所有音频
    public List<Chapter> queryAll();
//    删除所有的音频
    public void delAll();
//    添加一个音频
    public void save(Chapter chapter);
//    修改音频的状态
    public void update(Chapter chapter);

}
