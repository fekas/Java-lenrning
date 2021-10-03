package com.zhongbin.demo;

import org.junit.Test;

public class CalcDemo {
	
	@Test
	public void test01() {
		int[] arr = new int[64 * 1024 * 1024];
		
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= 3;
		}
		System.out.println("ѭ��1��ʱ:" + (System.currentTimeMillis() - start1) + "ms");
		
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i += 16) {
			arr[i] *= 3;
		}
		System.out.println("ѭ��2��ʱ:" + (System.currentTimeMillis() - start2) + "ms");
		
		long start3 = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i += 32) {
			arr[i] *= 3;
		}
		System.out.println("ѭ��3��ʱ:" + (System.currentTimeMillis() - start3) + "ms");
		
		long start4 = System.currentTimeMillis();
		for (int i = 0; i < arr.length / 16 ; i++) {
			arr[i] *= 3;
		}
		System.out.println("ѭ��4��ʱ:" + (System.currentTimeMillis() - start4) + "ms");
		
		//Ϊʲô��ʱ��಻��
	}

}
