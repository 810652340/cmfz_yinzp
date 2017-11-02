package com.baizhi.yinzp.entity;

/**
 * Created by Administrator on 2017/10/31.
 */
public class CityFB {
    private String name;
    private String value;

    @Override
    public String toString() {
        return "CityFB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
