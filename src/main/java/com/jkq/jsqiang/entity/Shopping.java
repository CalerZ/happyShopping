package com.jkq.jsqiang.entity;

import java.util.Date;

public class Shopping {
    private Integer id;

    private String foodname;

    private String username;

    private Integer num;

    private Double price;

    private Integer total;

    private String name;

    private String foodsstatus;

    private String transportstatus;

    private Date time;

    private String phone;

    private String address;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFoodsstatus() {
        return foodsstatus;
    }

    public void setFoodsstatus(String foodsstatus) {
        this.foodsstatus = foodsstatus == null ? null : foodsstatus.trim();
    }

    public String getTransportstatus() {
        return transportstatus;
    }

    public void setTransportstatus(String transportstatus) {
        this.transportstatus = transportstatus == null ? null : transportstatus.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}