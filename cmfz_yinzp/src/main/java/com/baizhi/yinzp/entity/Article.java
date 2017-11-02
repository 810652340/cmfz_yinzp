package com.baizhi.yinzp.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
public class Article {
    private String id;
    private String title;
    @JSONField(format = "yyyy-MM-dd")
    private Date createDate;
    private String link;
    private String ext;
    private String texts;
    private String illustration;
    private String guruid;
    private String status;
    private Guru children;

    public Guru getChildren() {
        return children;
    }

    public void setChildren(Guru children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public String getGuruid() {
        return guruid;
    }

    public void setGuruid(String guruid) {
        this.guruid = guruid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                ", link='" + link + '\'' +
                ", ext='" + ext + '\'' +
                ", texts='" + texts + '\'' +
                ", illustration='" + illustration + '\'' +
                ", guruid='" + guruid + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
