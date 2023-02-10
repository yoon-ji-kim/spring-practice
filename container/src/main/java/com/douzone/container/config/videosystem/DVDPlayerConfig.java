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
	@Bean
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}
}
