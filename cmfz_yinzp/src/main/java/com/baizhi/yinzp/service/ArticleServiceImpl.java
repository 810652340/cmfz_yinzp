package com.baizhi.yinzp.service;

import com.baizhi.yinzp.annotation.LogAnnotation;
import com.baizhi.yinzp.dao.ArticleDAO;
import com.baizhi.yinzp.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service("/articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Article> queryAll() {
        List<Article> articles = articleDAO.queryAll();
        return articles;
    }

    @Override
    @LogAnnotation(description = "添加文章")
    public void save(Article article) {
        articleDAO.save(article);
    }

    @Override
    @LogAnnotation(description = "修改文章状态")
    public void update(Article article) {
        articleDAO.update(article);
    }
}
