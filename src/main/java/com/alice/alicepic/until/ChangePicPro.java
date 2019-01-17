package com.alice.alicepic.until;

import com.alice.alicepic.entity.Pic;
import com.alice.alicepic.entity.PicPro;

import java.util.ArrayList;
import java.util.List;

public class ChangePicPro {

    public static List<PicPro> changePicPro(List<Pic> pics){
        if (pics.isEmpty()){
            return new ArrayList<>();
        }
        List<PicPro> picPros = new ArrayList<>();
        for (Pic pic:pics){
            picPros.add(new PicPro(pic.getPic_id(),pic.getPic_name(),pic.getDescription(),pic.getLikes(),pic.getSrc(),TimeType.getMessageTimeText(pic.getTime()),pic.getDownload()));
        }
        return picPros;
    }
}
