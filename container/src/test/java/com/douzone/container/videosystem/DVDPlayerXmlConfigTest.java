package com.douzone.container.videosystem;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


//spring에서 제공해주는 runner 설정: Container 안에서 작동
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:com/douzone/container/config/videosystem/applicationContext.xml"}) //container 설정
public class DVDPlayerXmlConfigTest {
	//인터페이스 주입
	@Autowired
	DigitalVideoDisc dvd1;
	
	@Test
	public void testDVD01() {
		assertNotNull(dvd1);
	}
}
