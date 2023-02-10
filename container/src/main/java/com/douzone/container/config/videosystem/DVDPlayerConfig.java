package com.douzone.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration //component scan 없어서 bean method 만들어야함
public class DVDPlayerConfig {

	@Bean
	public DigitalVideoDisc avengers() { //주입해야하는거
		return new Avengers();
	}

	// Injection(주입하기) 1. Bean 생성 메소드를 직접 호출하는 방법, 생성자 주입
	@Bean("dvdPlayer") //id를 지정하고 싶을 때
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}
	
	// Injection(주입하기) 2. Parameter로 bean을 전달하는 방법, 생성자 주입
	@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	// Injection(주입하기) 3. Parameter로 bean을 전달하는 방법, Setter 주입
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		return dvdPlayer;
	}
}
