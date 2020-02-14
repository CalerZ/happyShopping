package com.jkq.jsqiang.entity;

import java.util.Date;

public class Message {
    private Integer id;

    private String foodname;

    private String username;

    private String usertime;

    private String businesstime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsertime() {
        return usertime;
    }

    public void setUsertime(String usertime) {
        this.usertime = usertime;
    }

    public String getBusinesstime() {
        return businesstime;
    }

    public void setBusinesstime(String businesstime) {
        this.businesstime = businesstime;
    }
}