package com.douzone.container.videosystem;

public class DVDPlayer {
	private DigitalVideoDisc dvd;
	//기본생성자 오버로딩
	public DVDPlayer() {
		
	}
	//주입하기 1
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
	
	public String play() {
		return dvd.play();
	}

}
