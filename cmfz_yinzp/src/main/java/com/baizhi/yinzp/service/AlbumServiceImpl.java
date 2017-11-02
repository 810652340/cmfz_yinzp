package com.baizhi.yinzp.service;

import com.baizhi.yinzp.annotation.LogAnnotation;
import com.baizhi.yinzp.dao.AlbumDAO;
import com.baizhi.yinzp.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> queryAll() {
        List<Album> albums = albumDAO.queryAll();
        return albums;
    }

    @Override
    @LogAnnotation(description = "添加音频专辑")
    public void save(Album album) {
        albumDAO.save(album);
    }

    @Override
    public void del(String id) {
        albumDAO.del(id);
    }
}
