package com.alice.alicepic.service;

import com.alice.alicepic.entity.Pic;
import com.alice.alicepic.entity.PicPro;

import java.util.List;

public interface PicService {
    boolean addPic(Pic pic);
    List<Pic> findAllPic();
    List<PicPro> findPic(int pageNumber, int pageSize);
    boolean uplikes(int id);
    boolean upDown(int id);
}