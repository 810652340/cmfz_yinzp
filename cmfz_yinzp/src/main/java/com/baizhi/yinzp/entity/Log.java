package com.baizhi.yinzp.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/31.
 */
public class Log {
    private String id;
    private String username;
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    private String doSomething;
    private String status;

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                ", doSomething='" + doSomething + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDoSomething() {
        return doSomething;
    }

    public void setDoSomething(String doSomething) {
        this.doSomething = doSomething;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
