package com.baizhi.yinzp.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/26.
 */
public class Banner {
//    这是专辑表
    private String id;
//    路径
    private String thumbnail;
//    图片描述
    private String descs;
//    状态
    private String status;
//    图片名称
    private String name;
//    上传时间
    private Date bir;
//    上传时名字
    private String oldName;

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", descs='" + descs + '\'' +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", bir=" + bir +
                ", oldName='" + oldName + '\'' +
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

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }
}
