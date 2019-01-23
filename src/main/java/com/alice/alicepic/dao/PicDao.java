package com.alice.alicepic.dao;

import com.alice.alicepic.entity.Pic;
import com.alice.alicepic.entity.Pics;

import java.util.List;

public interface PicDao {
    int insertPic(Pic pic);
    List<Pic> selectAllPic();
    List<Pic> selectPic(int pageStart,int pageSize);
    int upLikes(int id);
    int upDownload(int id);
    int insertPics(Pics pics);
    List<Pics> selectAllPics();
    int deletePicsId(int id);
    List<Pic> selectPicLikeName(String name,int pageStart,int pageSize);
}
