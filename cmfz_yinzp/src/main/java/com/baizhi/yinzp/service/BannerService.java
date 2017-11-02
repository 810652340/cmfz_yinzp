package com.baizhi.yinzp.service;

import com.baizhi.yinzp.entity.Banner;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface BannerService {
    //    展示所有图片
    public List<Banner> queryAll();
    //    修改图片的状态
    public void update(Banner banner);
//    添加一张图
    public void save(Banner banner);
//    计算数据的条数
    public Integer queryNum();
}
