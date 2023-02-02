package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * AOP 설정
 * AOP 설정 Component
 * 스캐닝 위치 추가, autoproxy 활성화 -> applicationContext
 * 
 */
@Aspect
@Component
public class MyAspect {
			//실행하는 지점
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("-------Before Advice -------");
	}
				//public 생략 가능 com.douzone.aoptest.vo.ProductVo ->리턴타입 * 패키지 줄이기 *..*(모든패키지)
	@After("execution(* *..*.ProductService.find(..))")
	public void adviceAfter() {
		System.out.println("-------After Advice -------");
	}
	
	//returning 후 실행								//모든메소드
	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void adviceAfterReturning() {
		System.out.println("-------AfterReturning Advice-------");
	}
	
//	@AfterThrowing("execution(* *..controller.*.*(..))") //컨트롤러의 모든 exception
	@AfterThrowing(value = "execution(* *..*.*.*(..))", throwing = "ex") //프로젝트의 모든 Bean, throwing하는 변수
	public void adviceAfterThrowing(Throwable ex) { //exception 받아오기
		System.out.println("-------AfterThrowing Advice: "+ ex +" -------");
	}
	
	//실행 앞 뒤
	@Around("execution(* *..*.ProductService.*(..))")
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable{//타겟되고 있는 메소드의 정보 
		//Before Advice
		System.out.println("-------Around(Before) Advice-------");
		//Point Cut Method 실행
			//파라미터 변경
//		Object[] params = {"Camera"};
//		Object result = pjp.proceed(params);
		Object result = pjp.proceed();
		//After Advice
		System.out.println("-------Around(After)Advice-------");
		
		return result;
	}
}
