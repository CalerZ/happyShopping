package com.jkq.jsqiang.entity;

import java.util.Date;

public class FoodSunSubscribe {
    private Integer id;

    private String username;

    private String foodname;

    private Integer total;

    private Integer num;

    private Date time;

    private String foodstatus;

    private String transportsatus;

    private Integer price;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFoodstatus() {
        return foodstatus;
    }

    public void setFoodstatus(String foodstatus) {
        this.foodstatus = foodstatus == null ? null : foodstatus.trim();
    }

    public String getTransportsatus() {
        return transportsatus;
    }

    public void setTransportsatus(String transportsatus) {
        this.transportsatus = transportsatus == null ? null : transportsatus.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}