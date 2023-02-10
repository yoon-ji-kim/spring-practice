package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuration(Annotation Scanning):beanFactory test
//		testBeanFactory01();
		// XML Bean Configuration(Explicit Configuration)
//		testBeanFactory02();
		
		// XML Auto Configuration(Annotation Scanning): ApplicationContext
//		testApplicationContext01();
		// XML Bean Configuration(Explicit Configuration)
		testApplicationContext02();
	}

	private static void testApplicationContext02() {
		ApplicationContext ac =new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext02.xml");
		User user = null;
		//id로 bean 가져오기 (명시적) - 에러 
		// - xml에서 id 설정 필요
		user = (User) ac.getBean("user");
		System.out.println(user.getName());
		//name으로 빈 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user.getName());
		
		//Type으로 빈 가져오기 - 캐스팅이 필요없음!
		// - 같은 타입의 빈이 2개 이상 있으면 Type으로 가져오기 실패
		// - Id 가져오기 또는 id + type 이나 name +type 가져오기 -타입으로 casting 에러 줄임
		user = ac.getBean("user2",User.class);
		System.out.println(user.getName());
		
		// 파라미터 2개인 생성자로 생성된 빈 가져오기 1
		user = ac.getBean("user3",User.class);
		System.out.println(user);
		
		// 파라미터 2개인 생성자로 생성된 빈 가져오기 2
		user = ac.getBean("user4",User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기 1
		user = ac.getBean("user5",User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기 2(DI된 빈 가져오기) 
		user = ac.getBean("user6",User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기 3(Collection Property - List, Collectrion) 
		user = ac.getBean("user7",User.class);
		System.out.println(user);
	}

	private static void testApplicationContext01() {
		ApplicationContext ac =new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext01.xml");
		//타입으로 가져오기 
		User user = null;
		user = ac.getBean(User.class);
		System.out.println(user.getName());
		//id로 bean 가져오기 (자동) 
		//  - Annotaion Scan 설정에서는 Bean Id가 자동으로 부여된다.
		user = (User)ac.getBean("user");
	}

	private static void testBeanFactory02() {
		BeanFactory bf =new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}

	private static void testBeanFactory01() {
		// 로직구현 (xml 설정 테스트 구현)
		//				BeanFactory 설정			xml위치
		BeanFactory bf =new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
					//User 클래스 타입의 bean 가져오기
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}
}
