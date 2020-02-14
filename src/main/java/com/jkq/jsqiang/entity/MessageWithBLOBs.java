package com.jkq.jsqiang.entity;

public class MessageWithBLOBs extends Message {
    private String usercontent;

    private String businesscontent;

    public String getUsercontent() {
        return usercontent;
    }

    public void setUsercontent(String usercontent) {
        this.usercontent = usercontent == null ? null : usercontent.trim();
    }

    public String getBusinesscontent() {
        return businesscontent;
    }

    public void setBusinesscontent(String businesscontent) {
        this.businesscontent = businesscontent == null ? null : businesscontent.trim();
    }
}