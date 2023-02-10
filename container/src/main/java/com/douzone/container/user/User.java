package com.douzone.container.user;

import java.util.List;

import org.springframework.stereotype.Component;

//Annotation Scan 할 수 있게 
@Component
public class User {
	private String name = "둘리";
	private Long no = 0L;
	//의존성 : 객체 주입
	private Friend friend;
	private List<String> friends;
	
	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(Long no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	//friend getter setter
	public Friend getFriend() {
		return friend;
	}
	
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", no=" + no + ", friend=" + friend + ", friends=" + friends + "]";
	}

}
