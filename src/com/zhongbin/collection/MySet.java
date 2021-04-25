package com.zhongbin.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.zhongbin.bean.User;

/**
 * 元素无序 ：存储的数据在底层并非按照数组的顺序添加，是按照数据的hash值选择添加的位置
 * 不可重复保证添加的元素按照equals方法判断时不能返回true
 * 
 * 元素添加过程：
 * 计算元素Hash值， 通过某种算法计算存放位置，判断该位置有没有元素，若没有元素，添加元素。
 * 有元素则比较hash值，如果hash值不同，添加元素，hash值相同，调用equals方法比较两个元素，
 * 如果返回true，证明元素相同，不添加，返回false，添加。以链表的方式在该位置储存。1.8以后新添加的元素在head位置，1.8以前在tail位置
 * 
 * 
 * 向set中添加数据，其所在的类必须重写hashCode()方法和equals()方法且尽可能保持一致性：让相同的对象有相同的hash值
 * 
 * 底层：数组+链表
 * @author XiaoBin
 * 2020年9月3日上午10:15:02
 */
public class MySet {

	//接口的主要实现类，线程不安全，可以存null
	Set<Object> hashSet = new HashSet<>();
	//HashSet的子类（添加指针），遍历其内部数据时可以按照其添加的顺序遍历
	Set<Object> linkedhashSet = new LinkedHashSet<>();
	//要求添加的数据都是同一个类的对象且需要实现comparable接口，可以按照添加对象指定属性进行排序。
	//因为底层是一个红黑树，所以比较的属性相同（comparable返回0）的无法放进去
	//若comparable接口的compareTo方法返回0，则TreeSet不会把该元素添加到set中
	Set<User> treeSet = new TreeSet<>();
	
	@Test
	public void testSet() throws Exception {
		
		User user01 = new User("zhangsan", 001, "zhangsan@hh.com");
		User user02 = new User("zhangsan", 001, "zhangsan@hh.com");
		User user03 = new User("zhangsan", 001, "zhangsan@hh.com");
		User user04 = new User("zhangsan", 001, "zhangsan@hh.com");
		
		hashSet.add("123");
		hashSet.add("123");
		hashSet.add("173");
		hashSet.add(user01);
		hashSet.add(user02);
		hashSet.add(user03);
		hashSet.add(user04);
		
		//迭代器遍历
		Iterator<Object> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		//加强for循环
		for (Object object : hashSet) {
			System.out.println(object);
		}
	}
	@Test
	public void testTreeSet() throws Exception {
		User user01 = new User("zhangsan", 1, "zhangsan@hh.com");
		User user02 = new User("AAA", 2, "AAAn@hh.com");
		User user03 = new User("BBB", 3, "BBB@hh.com");
		User user04 = new User("HHH", 4, "HHH@hh.com");
		
		treeSet.add(user01);
		treeSet.add(user02);
		treeSet.add(user03);
		treeSet.add(user04);
		
		for (User u : treeSet) {
			System.out.println(u);
		}
		
		
		//隐式
		TreeSet<User> treeSet2 = new TreeSet<>(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}
}
