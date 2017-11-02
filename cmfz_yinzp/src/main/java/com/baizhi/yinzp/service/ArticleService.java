package com.baizhi.yinzp.service;

import com.baizhi.yinzp.entity.Article;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface ArticleService {
    //    查看上师所有的文章
    public List<Article> queryAll();
    //    添加一篇文章
    public void save(Article article);
    //    修改文章的状态
    public void update(Article article);
}
