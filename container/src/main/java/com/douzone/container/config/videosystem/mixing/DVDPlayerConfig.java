package com.douzone.container.config.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

/*
 * JavaConfig2(DVDPlayerConfig)<------ JavaConfig1 (DVDConfig)
 * 								import
 * : JavaConfig1 + JavaConfig2
 */								
@Configuration
@Import({DVDConfig.class})
public class DVDPlayerConfig {
	@Bean						//주입 받을 것 명시
	public DVDPlayer dvdPlayer(@Qualifier("avengersInfinityWar") DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
}
