package com.douzone.container.videosystem;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


//spring에서 제공해주는 runner 설정: Container 안에서 작동
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:com/douzone/container/config/videosystem/applicationContext.xml"}) //container 설정
public class DVDPlayerXmlConfigTest {
	//인터페이스 주입
//	@Autowired
//	container wiring 시 예외 발생 
//	XML Bean Configuration(Avengers)에서는 자동으로 id를 부여하지 않는다
//	@Qualifier를 사용할 수 없다.
	DigitalVideoDisc dvd1;
	
	@Autowired
	@Qualifier("ironMan")
	DigitalVideoDisc dvd2;
	
	@Autowired
	@Qualifier("avengersInfinityWar")
	DigitalVideoDisc dvd3;
	
	@Autowired
	@Qualifier("avengersEndgame")
	DigitalVideoDisc dvd4;
	
	@Autowired
	@Qualifier("avengersAgeofUltron")
	DigitalVideoDisc dvd5;
	
	@Autowired
	@Qualifier("avengersCaptainAmerica")
	DigitalVideoDisc dvd6;
	
	@Autowired
	@Qualifier("avengersDirectorEdition")
	DigitalVideoDisc dvd7;
	
	@Autowired
	DVDPack dvdPack;
	
	@Autowired
	@Qualifier("avengersExpansionEdition1")
	DigitalVideoDisc dvd8;
	
	@Autowired
	@Qualifier("avengersExpansionEdition2")
	DigitalVideoDisc dvd9;
	
	@Autowired
	@Qualifier("avengersExpansionEdition3")
	DigitalVideoDisc dvd10;
	
	//DVDPlayer Test
	@Autowired
	@Qualifier("dvdPlayer1")
	DVDPlayer dvdPlayer1;
	
	@Autowired
	@Qualifier("dvdPlayer2")
	DVDPlayer dvdPlayer2;
	
	@Autowired
	@Qualifier("dvdPlayer3")
	DVDPlayer dvdPlayer3;
	
	@Autowired
	@Qualifier("dvdPlayer4")
	DVDPlayer dvdPlayer4;
	
	@Autowired
	@Qualifier("dvdPlayer5")
	DVDPlayer dvdPlayer5;
	/////////////////////////////////////////

	@Disabled  //테스트 안함
	@Test
	public void testDVD01() {
		assertNotNull(dvd1);
	}
	
	@Test
	public void testDVD02() {
		assertNotNull(dvd2);
	}
	
	@Test
	public void testDVD03() {
		assertNotNull(dvd3);
	}
	
	@Test
	public void testDVD04() {
		assertNotNull(dvd4);
	}
	
	@Test
	public void testDVD05() {
		assertNotNull(dvd5);
	}
	
	@Test
	public void testDVD06() {
		assertNotNull(dvd6);
	}
	
	@Test
	public void testDVDPack() {
		System.out.println(dvdPack);
		assertNotNull(dvdPack);
	}
	
	@Test
	public void testDVD07() {
		assertNotNull(dvd7);
	}
	
	@Test
	public void testDVD08() {
		assertNotNull(dvd8);
	}
	
	@Test
	public void testDVD09() {
		assertNotNull(dvd9);
	}
	
	@Test
	public void testDVD10() {
		assertNotNull(dvd10);
	}
	
	@Test
	public void testPlay1() {
		assertEquals("Playing Movie MARVEL's IronMan", dvdPlayer1.play());
	}
	
	@Test
	public void testPlay2() {
		assertEquals("Playing Movie MARVEL's IronMan", dvdPlayer2.play());
	}
	
	@Test
	public void testPlay3() {
		assertEquals("Playing Movie MARVEL's IronMan", dvdPlayer3.play());
	}
	
	@Test
	public void testPlay4() {
		assertEquals("Playing Movie MARVEL's IronMan", dvdPlayer4.play());
	}
	
	@Test
	public void testPlay5() {
		assertEquals("Playing Movie MARVEL's IronMan", dvdPlayer5.play());
	}
}
