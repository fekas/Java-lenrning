package com.zhongbin.genericity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhongbin.bean.User;

/**
 * 泛型：jdk1.5新增的特性
 * 在程序编码中一些包含类型参数的类型，也就是说泛型的参数只可以代表类，不能代表个别对象。
 * 允许在定义类，接口时通过一定的标识表示类中的某个属性的类型或者是某个方法的返回值及参数的类型。这个类型参数在使用时确定
 * @author XiaoBin
 * 2020年9月16日下午8:37:00
 */
public class GenericTest{

	@Test
	public void testInCollection() throws Exception {
		//在集合中使用泛型让集合只能存储指定一种类型的对象
		List<User> ulist = new ArrayList<>();
		ulist.add(new User("QAQ",1,"QAQ@qq.com"));
		
	}
	
	//若申明时不添加泛型则看作(但不等价)Object类型处理
	@Test
	public void testMyGeneric() throws Exception {
		MyGeneric<User> myGeneric = new MyGeneric<>();
		
		String[] arr = new String[]{"qqq","aaa","qaq","AQA"};
		List<String> copyToList = MyGeneric.copyToList(arr);
		
		for (String s : copyToList) {
			System.out.println(s);
		}
	}
	
	/**
	 * 通配符?的使用
	 * 对于List<?>不能向里面添加数据(null除外)，但可以读里面的数据，返回对象为Object
	 * 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是G<?>
	 * 
	 * 有限制条件的通配符
	 * ? extends ClassName	使用时指定的类型必须继承ClassName
	 * ? super ClassName	使用时指定的类型不能小于操作的类
	 * ? extends Comparable	只允许泛型为实现Comparable接口的实现类引用
	 */
	@Test
	public void test01() throws Exception {
		List<Object> list1 = new ArrayList<>();
		
		list1.add("123");
		list1.add(111);
		list1.add("QAQ");
		List<String> list2 = null;
		
		List<?> list = null;
		
		list = list1;
		
	}
}
