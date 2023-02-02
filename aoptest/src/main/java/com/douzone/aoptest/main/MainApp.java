package com.douzone.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douzone.aoptest.service.ProductService;
import com.douzone.aoptest.vo.ProductVo;

public class MainApp {

	public static void main(String[] args) {
		//컨테이너생성
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.class);
		//메소드 부르기
		ProductVo vo = ps.find("TV");
		//화면 출력
		System.out.println(vo);
		
		((AbstractApplicationContext)ac).close();
	}

}
