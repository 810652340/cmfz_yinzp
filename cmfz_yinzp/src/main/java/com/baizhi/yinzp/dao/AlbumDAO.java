package com.baizhi.yinzp.dao;

import com.baizhi.yinzp.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface AlbumDAO {
//    查询所有专辑
    public List<Album> queryAll();
//    添加一张专辑
    public void save(Album album);
//    删除一张专辑
    public void del(String id);
}
