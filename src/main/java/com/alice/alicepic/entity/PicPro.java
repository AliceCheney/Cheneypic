package com.alice.alicepic.entity;

public class PicPro {
    private Integer pic_id;
    private String pic_name;
    private String description;
    private Integer likes;
    private String src;
    private String time;
    private int download;

    public PicPro(Integer pic_id, String pic_name, String description, Integer likes, String src, String time, int download) {
        this.pic_id = pic_id;
        this.pic_name = pic_name;
        this.description = description;
        this.likes = likes;
        this.src = src;
        this.time = time;
        this.download = download;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }
}
