package com.jkq.jsqiang.entity;

public class FoodSunSubscribeWithBLOBs extends FoodSunSubscribe {
    private String address;

    private String content;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}