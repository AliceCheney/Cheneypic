package com.alice.alicepic.service.serviceimpl;

import com.alice.alicepic.dao.PicDao;
import com.alice.alicepic.entity.Pic;
import com.alice.alicepic.entity.PicPro;
import com.alice.alicepic.entity.Pics;
import com.alice.alicepic.service.PicService;
import com.alice.alicepic.until.ChangePicPro;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PicServiceImpl implements PicService {
    @Resource
    PicDao picDao;

    @Override
    public boolean addPic(Pic pic) {
        return 1 == picDao.insertPic(pic);
    }

    @Override
    public List<Pic> findAllPic() {
        return picDao.selectAllPic();
    }

    @Override
    public List<PicPro> findPic(int pageNumber, int pageSize) {
        return ChangePicPro.changePicPro(picDao.selectPic((pageNumber-1)*pageSize,pageSize));
    }

    @Override
    public boolean uplikes(int id) {
        return 1==picDao.upLikes(id);
    }

    @Override
    public boolean upDown(int id) {
        return 1==picDao.upDownload(id);
    }

    @Override
    public boolean addPics(Pics pics) {
        return 1==picDao.insertPics(pics);
    }

    @Override
    public List<Pics> findAllPics() {
        return picDao.selectAllPics();
    }

    @Override
    public boolean delPicsById(int id) {
        return 1==picDao.deletePicsId(id);
    }
}
