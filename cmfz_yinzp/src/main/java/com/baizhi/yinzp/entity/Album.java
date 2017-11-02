package com.baizhi.yinzp.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Album {
    private String id;
//    专辑图片路径
    private String thumbnail;
//     图片名字
    private String newName;
//    图片旧名字
    private String oldName;
//    专辑名称
    private String title;
//    专辑级数
    private Integer setCount;
//    发布日期
    private Date createDate;
//    分数
    private double score;
//    作者
    private String author;
//    播音
    private String broadcast;
//    内容简介
    private String brief;
//    状态
    private String status;
    private String zid;

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid;
    }

    //    维护关系属性
    private List<Chapter> children;

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", newName='" + newName + '\'' +
                ", oldName='" + oldName + '\'' +
                ", title='" + title + '\'' +
                ", setCount=" + setCount +
                ", createDate=" + createDate +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", brief='" + brief + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSetCount() {
        return setCount;
    }

    public void setSetCount(Integer setCount) {
        this.setCount = setCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
