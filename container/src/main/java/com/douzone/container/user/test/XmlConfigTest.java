package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		//1. XML Auto Configuration(Annotation Scanning):beanFactory test
		testBeanFactory01();
	}

	private static void testBeanFactory01() {
		//2. 로직구현 (xml 설정 테스트 구현)
		//				BeanFactory 설정			xml위치
		BeanFactory bf =new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext.xml"));
					//User 클래스 타입의 bean 가져오기
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}
}
