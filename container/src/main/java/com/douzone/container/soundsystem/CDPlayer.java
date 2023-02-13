package com.douzone.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	@Autowired
	private CompactDisc cd;

	//Autowired 방식 말고 자바 DI 원리에 따른 방식
//	CDPlayer(CompactDisc cd) {
//		this.cd = cd;
//	}
	
	public String play() {
		return cd.play();
	}

}
