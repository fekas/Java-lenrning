package com.zhongbin.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * �Զ�������͵�����߽ӿ�
 * ��̬������������ķ��ͣ��쳣�಻������Ϊ�����ࡣ
 * @author XiaoBin
 * 2020��9��17������8:22:28
 * @param <T>
 */
public class MyGeneric<T> {

	String name;
	String age;
	T t;
	
	public MyGeneric(String name, String age, T t) {
		super();
		this.name = name;
		this.age = age;
		this.t = t;
	}
	public MyGeneric() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
	/*���ͷ������ڷ����г����˷��͵Ľṹ 
	���η� + static(��ѡ) + ��������  + ����ֵ +������ +(�����б�){};
	���ͷ�����������Ϊ��̬��������Ϊ���Ͳ������ڵ��÷���ʱȷ���ģ�������ʵ����ʱȷ����
	���Ҫ����ķ��Ͳ�������ʹ�þ�̬��������Ϊ��ķ��Ͳ������������ʱ��Ҫȷ��*/
	public static <E> List<E> copyToList(E[] arr){
		ArrayList<E> list = new ArrayList<>();
		
		for (E e : arr) {
			list.add(e);
		}
		return list;
	}
}
