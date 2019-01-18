package com.alice.alicepic.entity;

public class Pics {
    private Integer pic_id;
    private String pic_name;
    private String description;
    private String src;
    private Long time;

    public Pics(String pic_name, String description, String src, Long time) {
        this.pic_name = pic_name;
        this.description = description;
        this.src = src;
        this.time = time;
    }

    public Pics() {
    }

    public Integer getPic_id() {
        return pic_id;
    }

    public void setPic_id(Integer pic_id) {
        this.pic_id = pic_id;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
