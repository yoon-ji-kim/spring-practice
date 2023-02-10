package com.douzone.container.videosystem;

public class DVDPlayer {
	private DigitalVideoDisc dvd;
	
	//주입하기 1
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	public String play() {
		return dvd.play();
	}

}
