package com.zhongbin.collection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

/**
 * List集合:存储元素有序，可重复
 * @author XiaoBin
 * 2020年9月3日上午10:14:35
 */
public class MyList {
	//作为List接口的主要实现类，线程不安全但效率高，使用Object[] elementData存储
	//ArrayList第一次调用add时创建长度为10的数组，添加元素时若容量不够则扩容1.5倍
	List<Object> arrayList = new ArrayList<>();
	//作为List接口的古老实现类，线程安全但效率低，使用Object[] elementData存储
	List<Object> v = new Vector<>();
	//底层使用的时双向链表存储，对于频繁的插入删除操作，效率比ArrayList高
	List<Object> linkedList = new LinkedList<>();
	
	@Test
	public void MyListTest() throws Exception {
		arrayList.add("12 3");
		arrayList.add(123);
		
		//1.用iterator遍历
		Iterator<Object> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		
		//2.增强for循环，用于遍历数组或集合
		for (Object object : arrayList) {
			System.out.println(object);
		}
	}
	
	@Test
	public void testRemove() throws Exception {
		int index = 100;
		Object o = new String("123");
		
		arrayList.remove(index);//移除index处的某个元素
		arrayList.remove(o);//移除某个元素
		
	}
}
