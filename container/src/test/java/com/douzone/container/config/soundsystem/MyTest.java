package com.douzone.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyTest {
	
	@Test
	public void test01() {
//		int i =120;
		int i =10;
		// assert 계열 함수
		assertTrue(i-10 <= 10); //assert가 true가 되어야 test ok
	}
	
	@Test
	public void test02() {
		int i =10;
		assertEquals(10, i); //expect값과 실제값이 같으면 
	}
}
