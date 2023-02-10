package com.douzone.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.soundsystem.CDPlayer;

//spring에서 제공해주는 runner 설정: Container 안에서 작동
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:com/douzone/container/config/soundsystem/applicationContext.xml"}) //container 설정
public class CDPlayerXmlConfigTest {
	@Autowired
	private CDPlayer cdPlayer;
	
	@Test
	public void testCDPlayerNotNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testInsert() {
		assertNotNull(cdPlayer);
	}
}
