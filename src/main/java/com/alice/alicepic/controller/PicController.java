package com.alice.alicepic.controller;

import com.alice.alicepic.entity.Pic;
import com.alice.alicepic.entity.PicPro;
import com.alice.alicepic.service.PicService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class PicController {

    @Resource
    PicService picService;

    @RequestMapping(value = "/uploadpic",headers = "Content-Type= multipart/form-data")
    public String uploadfile(@RequestParam(value = "file")
                             MultipartFile file,
                             @RequestParam(value = "name")
                             String name,
                             @RequestParam(value = "desc")
                             String desc){
        byte[] fileByte;
        try {
            fileByte = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String cropUuid = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        String filename = file.getOriginalFilename();
        String fileType = null;
        for (int i = filename.length();i>0;i--){
            if (filename.substring(i-1,i).equals(".")){
                fileType = filename.substring(i-1);
                break;
            }
        }
        Path path = Paths.get("/usr/share/nginx/html/image/"+cropUuid+fileType);
        try {
            Files.write(path,fileByte);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        try {
            if(fileType.equals(".gif")){
                if (fileByte.length<1024*500){
                    if(picService.addPic(new Pic(name,desc,"image/"+cropUuid+fileType,new Date().getTime()))){
                        return "successful";
                    }else {
                        return "error";
                    }
                } else if(fileByte.length>1024*500&&fileByte.length<1024*1024*2){
                    Thumbnails.of("/usr/share/nginx/html/image/" + cropUuid+fileType)
                            .scale(1f)
                            .outputQuality(0.25f)
                            .toFile("/usr/share/nginx/html/image/" + cropUuid+fileType);
                    if(picService.addPic(new Pic(name,desc,"image/"+cropUuid+fileType,new Date().getTime()))){
                        return "successful";
                    }else {
                        return "error";
                    }
                } else if(fileByte.length > 1024*1024*2){
                    Thumbnails.of("/usr/share/nginx/html/image/" + cropUuid+fileType)
                            .scale(0.5f)
                            .outputQuality(0.25f)
                            .toFile("/usr/share/nginx/html/image/" + cropUuid+fileType);
                    if(picService.addPic(new Pic(name,desc,"image/"+cropUuid+fileType,new Date().getTime()))){
                        return "successful";
                    }else {
                        return "error";
                    }
                }
            } else if (fileByte.length < 1024*70){
                if(picService.addPic(new Pic(name,desc,"image/"+cropUuid+fileType,new Date().getTime()))){
                    return "successful";
                }else {
                    return "error";
                }
            } else if(fileByte.length > 1024*70 && fileByte.length < 1024*100){
                Thumbnails.of("/usr/share/nginx/html/image/" + cropUuid+fileType)
                        .scale(1f)
                        .outputQuality(0.5f)
                        .toFile("/usr/share/nginx/html/image/" + cropUuid+fileType);
            } else if (fileByte.length > 1024*100 && fileByte.length < 1024*512){
                Thumbnails.of("/usr/share/nginx/html/image/" + cropUuid+fileType)
                        .scale(0.8f)
                        .outputQuality(0.25f)
                        .toFile("/usr/share/nginx/html/image/" + cropUuid+fileType);
            } else if (fileByte.length > 1024*512 && fileByte.length < 1024*1024){
                Thumbnails.of("/usr/share/nginx/html/image/" +cropUuid+fileType)
                        .scale(0.5f)
                        .outputQuality(0.25f)
                        .toFile("/usr/share/nginx/html/image/" + cropUuid+fileType);
            } else if(fileByte.length > 1024*1024){
                Thumbnails.of("/usr/share/nginx/html/image/" +cropUuid+fileType)
                        .scale(0.25f)
                        .outputQuality(0.25f)
                        .toFile("/usr/share/nginx/html/image/" + cropUuid+fileType);
            }
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        if(picService.addPic(new Pic(name,desc,"image/"+cropUuid+fileType,new Date().getTime()))){
            return "successful";
        }else {
            return "error";
        }
    }

    @RequestMapping("/getallpic")
    public List<Pic> getallpic(){
        return picService.findAllPic();
    }

    @RequestMapping("/getpic")
    public Map getPic(@RequestParam(value = "pagenumber")
                            int pagenumber,
                      @RequestParam(value = "pagesize")
                            int pagesize){
        Map map = new HashMap();
        if(pagenumber<1){
            map.put("info","error");
            return map;
        }
        List<PicPro> picList =picService.findPic(pagenumber,pagesize);
        if (picList.isEmpty()){
            map.put("info","Empty");
            return map;
        }
        map.put("info",picList);
        return map;
    }
    @RequestMapping("/uplikes")
    public String upLikes(@RequestParam(value = "id")
                                  int id){
        if(picService.uplikes(id)){
            return "successful";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updown")
    public String upDown(@RequestParam(value = "id")
                         int id){
        if (picService.upDown(id)){
            return "successful";
        }else {
            return "error";
        }
    }
}
