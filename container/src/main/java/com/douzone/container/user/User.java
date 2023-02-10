package com.douzone.container.user;

import org.springframework.stereotype.Component;

//Annotation Scan 할 수 있게 
@Component
public class User {
	private String name = "둘리";
	public String getName() {
		return name;
	}

}
