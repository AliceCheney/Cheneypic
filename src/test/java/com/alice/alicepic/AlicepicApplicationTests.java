package com.alice.alicepic;

import com.alice.alicepic.dao.PicDao;
import com.alice.alicepic.entity.Pic;
import com.alice.alicepic.entity.Pics;
import com.alice.alicepic.service.PicService;
import com.alice.alicepic.until.TimeType;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.tomcat.jni.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlicepicApplicationTests {
	@Resource
	PicService picService;

	@Test
	public void contextLoads() {
	}
}

