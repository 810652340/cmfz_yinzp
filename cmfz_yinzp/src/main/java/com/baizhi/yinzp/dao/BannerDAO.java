package com.baizhi.yinzp.dao;

import com.baizhi.yinzp.entity.Banner;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface BannerDAO {
//    展示所有图片
    public List<Banner> queryAll();
//    修改图片的状态和描述
    public void update(Banner banner);
//    添加一张图片
    public void save(Banner banner);
//    一共有多少数据
    public Integer queryNum();
//    删除一张照片
    public void delete();
}
