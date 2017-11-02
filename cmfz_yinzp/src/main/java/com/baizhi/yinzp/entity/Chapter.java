package com.baizhi.yinzp.entity;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Chapter {
    private String id;
//    第几集
    private String title;
//    路径
    private String downloadUrl;
//    音频大小
    private double size;
//    时长
    private double duration;
//    新建文件名
    private String newName;
//    原来的名字
    private String oldName;
//    外键
    private String albumId;
//    维护关系
    private Album album;
//   状态
    private String status;

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", size=" + size +
                ", duration='" + duration + '\'' +
                ", newName='" + newName + '\'' +
                ", oldName='" + oldName + '\'' +
                ", albumId='" + albumId + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
