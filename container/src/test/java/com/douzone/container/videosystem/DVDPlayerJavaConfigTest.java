package com.douzone.container.videosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.config.videosystem.DVDPlayerConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {DVDPlayerConfig.class})
public class DVDPlayerJavaConfigTest {
//	@Autowired
//	private DVDPlayer dvdPlayer;
	/*
	 * 	@Qualifier
	 * 		- 같은 타입의 여러 빈(DVDPlayer) 중 하나를 고를때 
	 * 		설정 클래스의 빈 생성 메소드 이름이 ID가 되서 Qualifier 하기 :dvdPlayer02
	 * 		또는 @Bean("설정할 ID")-> default인 name 속성을 사용  :@Qualifier("dvdPlayer")
	 */
	@Qualifier("dvdPlayer")
	@Autowired
	private DVDPlayer dvdPlayer01;
	
	@Qualifier("dvdPlayer02") 
	@Autowired
	private DVDPlayer dvdPlayer02;
	
	@Autowired
	@Qualifier("dvdPlayer03") 
	private DVDPlayer dvdPlayer03;
	
	@Test
	public void testDVDPlayer01NotNull() {
		assertNotNull(dvdPlayer01);
	}
	
	@Test
	public void testDVDPlayer02NotNull() {
		assertNotNull(dvdPlayer02);
	}
	
	@Test
	public void testDVDPlayer03NotNull() {
		assertNotNull(dvdPlayer03);
	}
	
	@Test
	public void testPlay() {
		assertEquals("Playing Movie MARVEL's Avengers", dvdPlayer03.play());
	}
}
