package com.zhongbin.map;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.zhongbin.bean.User;

import java.util.LinkedHashMap;

/**
 * |---Map(interface)
 * 		|---HashMap
 * 			|---LinkedHashMap
 * 		|---Hashtable
 * 			|---Properties
 * 		|---SortedMap(interface)
 * 			|---TreeMap
 * 
 * key-value
 * key是不能重复且无序的，用set存储key  -->key所在的类要重写equals()和HashCode()方法(以HashMap为例)
 * value可重复，用collection存储value -->value所在的类重写equals()方法
 * Map将key-value封装成一个entry对象然后用相应的set存起来
 * 
 * HashMap底层：数组+链表	jdk1.8后添加了红黑树
 * Map hashMap = new HashMap<>();------->创建长度为16的entry数组 Entry[] table
 * map.put(key1,value1)----->计算key的hash值，通过某些算法得到存储位置
 * 								该位置为null，entry添加成功
 * 								该位置存在值，比较key1和已存在在该位置的key的hash值
 * 									hash值都不相同，entry添加成功
 * 									和某个key的hash值相同，调用key1所在类equals()方法
 * 										返回false：添加成功
 * 										返回true：用value1替换该value的值(相当于修改了某个值)
 * 
 * 扩容比例：2倍。
 * 
 * jdk8:
 * 	在new HashMap<>();时没有创建数组，
 * 	在调用put()方法时创建Node[]数组
 * 	当每个Node上的链表节点数大于8，且Node[]数组长度大于64时，索引上的链表改为红黑树存储
 * 
 * 多线程下用CurrentHashMap
 * @author XiaoBin
 * 2020年9月3日上午10:17:43
 */
public class MyMap {
	
	//Map的常用实现类,线程不安全，效率高，可以存null的key-value
	Map<Object, Object> hashMap = new HashMap<>();
	//Map的古老实现类，线程不安全，效率低，不可以存null的key-value
	Map<Object, Object> hashtable = new Hashtable<>();
	//HashMap的子类，在其之上添加指针
	Map<Object, Object> LinkedHashMap = new LinkedHashMap<>();
	//保证按照添加的key-value进行排序(按照key排序,所以key属于同一个可排序类类)，然后实现排序遍历,使用的是红黑树
	Map<Object, Object> treeMap = new TreeMap<>();
	//常用来处理配置文件，key和value都是String类型
	Properties properties = new Properties();
	
	@Test
	public void test01() throws Exception {
		hashMap.put("username", "zhangsan");
		hashMap.put("email", "zhangsan@qqq.com");
		hashMap.put("age", 18);
		
		//System.out.println(hashMap);
		
		//map的遍历
		//遍历key集合
		Set<Object> keySet = hashMap.keySet();
		for (Object object : keySet) {
			System.out.println(object);
		}
		System.out.println("==========================");
		//遍历value的collection
		Collection<Object> values = hashMap.values();
		for (@SuppressWarnings("unused") Object object : values) {
			System.out.println(values);
		}
		System.out.println("==========================");
		//遍历所有的key-value
		Set<Entry<Object,Object>> entrySet = hashMap.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry);
		}
	}
	@Test
	public void test02() throws Exception {
		
		/*User user01 = new User("zhangsan", 1, "zhangsan@hh.com");
		User user02 = new User("zhangsan", 2, "zhangsan@hh.com");
		User user03 = new User("zhangsan", 3, "zhangsan@hh.com");
		
		//TreeSet的key值必须是一个可排序的对象，若两个key按照排序规则排序相同，则后来的会更新前面的value
		Object put1 = treeMap.put(user01, "111111");
		Object put2 = treeMap.put(user02, "222222");
		Object put3 = treeMap.put(user03, "333333");
		System.out.println(put1+"   "+put2+"   "+put3);
		
		Set<Entry<Object,Object>> entrySet = treeMap.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry);
		}*/
		
		TreeMap<User,Object> treeMap2 = new TreeMap<>(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				
				return o2.getId()-o1.getId();
			}
		});
		User user04 = new User("zhangsan", 6, "zhangsan@hh.com");
		User user05 = new User("zhangsan", 2, "zhangsan@hh.com");
		User user06 = new User("zhangsan", 3, "zhangsan@hh.com");
		
		treeMap2.put(user04, "111111");
		treeMap2.put(user05, "222222");
		treeMap2.put(user06, "333333");
		
		Set<Entry<User,Object>> entrySet2 = treeMap2.entrySet();
		for (Entry<User, Object> entry : entrySet2) {
			System.out.println(entry);
		}
	}
	@Test
	public void test03() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\HP\\Desktop\\Code\\Java-lenrning\\conf\\dbconfig.properties");
		
		properties.load(fileInputStream);
		
		properties.getProperty("jdbc.username");
		properties.getProperty("jdbc.password");
		
		System.out.println(properties);
		
		fileInputStream.close();
	}
	
	
}
