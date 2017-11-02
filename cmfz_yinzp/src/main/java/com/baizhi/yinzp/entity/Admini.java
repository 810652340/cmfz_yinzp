package com.baizhi.yinzp.entity;

/**
 * Created by Administrator on 2017/10/25.
 */
public class Admini {
    private String id;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "Admini{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
