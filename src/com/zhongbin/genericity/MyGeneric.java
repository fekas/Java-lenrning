package com.zhongbin.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义带泛型的类或者接口
 * 静态方法不能用类的泛型，异常类不能申明为泛型类。
 * @author XiaoBin
 * 2020年9月17日上午8:22:28
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
	
	/*泛型方法：在方法中出现了泛型的结构 
	修饰符 + static(可选) + 泛型申明  + 返回值 +方法名 +(参数列表){};
	泛型方法可以声明为静态方法，因为泛型参数是在调用方法时确定的，并非在实例化时确定。
	如果要用类的泛型参数则不能使用静态方法，因为类的泛型参数是在类加载时就要确定*/
	public static <E> List<E> copyToList(E[] arr){
		ArrayList<E> list = new ArrayList<>();
		
		for (E e : arr) {
			list.add(e);
		}
		return list;
	}
}
