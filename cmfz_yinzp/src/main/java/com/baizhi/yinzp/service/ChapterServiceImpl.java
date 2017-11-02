package com.baizhi.yinzp.service;

import com.baizhi.yinzp.annotation.LogAnnotation;
import com.baizhi.yinzp.dao.ChapterDAO;
import com.baizhi.yinzp.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;
    @Override
    public List<Chapter> queryAll() {
        List<Chapter> chapters = chapterDAO.queryAll();
        return chapters;
    }

    @Override
    public void delAll() {
        chapterDAO.delAll();
    }

    @Override
    @LogAnnotation(description = "添加音频")
    public void save(Chapter chapter) {
        chapterDAO.save(chapter);
    }

    @Override
    @LogAnnotation(description = "修改音频状态")
    public void update(Chapter chapter) {
        chapterDAO.update(chapter);
    }
}
