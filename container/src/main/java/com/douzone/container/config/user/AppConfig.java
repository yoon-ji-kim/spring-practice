package com.douzone.container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.Friend;
import com.douzone.container.user.User;

@Configuration
@ComponentScan(basePackages = {"com.douzone.container.user"}) //여기 지점을 Scanning
public class AppConfig {
	//빈 생성할 메소드 메소드 이름: ID가 됨
//	@Bean
//	public User user() {
//		return new User();
//	}
	
	@Bean
	public Friend friend() {
		return new Friend("Loopy");
	}
}
