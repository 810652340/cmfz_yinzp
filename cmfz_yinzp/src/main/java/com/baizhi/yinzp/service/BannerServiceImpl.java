package com.baizhi.yinzp.service;

import com.baizhi.yinzp.annotation.LogAnnotation;
import com.baizhi.yinzp.dao.BannerDAO;
import com.baizhi.yinzp.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
@Service("bannerService")
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDAO bannerDAO;
    @Override
    public List<Banner> queryAll() {
        List<Banner> banners = bannerDAO.queryAll();
        return banners;
    }

    @Override
    @Transactional
    @LogAnnotation(description = "修改轮播图")
    public void update(Banner banner) {
        bannerDAO.update(banner);
    }

    @Override
    @Transactional
    @LogAnnotation(description = "添加轮播图")
    public void save(Banner banner) {
        bannerDAO.save(banner);
    }

    @Override
    public Integer queryNum() {
        Integer integer = bannerDAO.queryNum();
        return integer;
    }
}
