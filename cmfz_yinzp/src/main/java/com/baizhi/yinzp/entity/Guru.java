package com.baizhi.yinzp.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
public class Guru {
    private String id;
    private String headpic;
    private String name;
    private String status;
    private List<Article> children;

    public List<Article> getChildren() {
        return children;
    }

    public void setChildren(List<Article> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", headpic='" + headpic + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
