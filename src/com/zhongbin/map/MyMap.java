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
 * key�ǲ����ظ�������ģ���set�洢key  -->key���ڵ���Ҫ��дequals()��HashCode()����(��HashMapΪ��)
 * value���ظ�����collection�洢value -->value���ڵ�����дequals()����
 * Map��key-value��װ��һ��entry����Ȼ������Ӧ��set������
 * 
 * HashMap�ײ㣺����+����	jdk1.8������˺����
 * Map hashMap = new HashMap<>();------->��������Ϊ16��entry���� Entry[] table
 * map.put(key1,value1)----->����key��hashֵ��ͨ��ĳЩ�㷨�õ��洢λ��
 * 								��λ��Ϊnull��entry��ӳɹ�
 * 								��λ�ô���ֵ���Ƚ�key1���Ѵ����ڸ�λ�õ�key��hashֵ
 * 									hashֵ������ͬ��entry��ӳɹ�
 * 									��ĳ��key��hashֵ��ͬ������key1������equals()����
 * 										����false����ӳɹ�
 * 										����true����value1�滻��value��ֵ(�൱���޸���ĳ��ֵ)
 * 
 * ���ݱ�����2����
 * 
 * jdk8:
 * 	��new HashMap<>();ʱû�д������飬
 * 	�ڵ���put()����ʱ����Node[]����
 * 	��ÿ��Node�ϵ�����ڵ�������8����Node[]���鳤�ȴ���64ʱ�������ϵ������Ϊ������洢
 * 
 * ���߳�����CurrentHashMap
 * @author XiaoBin
 * 2020��9��3������10:17:43
 */
public class MyMap {
	
	//Map�ĳ���ʵ����,�̲߳���ȫ��Ч�ʸߣ����Դ�null��key-value
	Map<Object, Object> hashMap = new HashMap<>();
	//Map�Ĺ���ʵ���࣬�̲߳���ȫ��Ч�ʵͣ������Դ�null��key-value
	Map<Object, Object> hashtable = new Hashtable<>();
	//HashMap�����࣬����֮�����ָ��
	Map<Object, Object> LinkedHashMap = new LinkedHashMap<>();
	//��֤������ӵ�key-value��������(����key����,����key����ͬһ������������)��Ȼ��ʵ���������,ʹ�õ��Ǻ����
	Map<Object, Object> treeMap = new TreeMap<>();
	//���������������ļ���key��value����String����
	Properties properties = new Properties();
	
	@Test
	public void test01() throws Exception {
		hashMap.put("username", "zhangsan");
		hashMap.put("email", "zhangsan@qqq.com");
		hashMap.put("age", 18);
		
		//System.out.println(hashMap);
		
		//map�ı���
		//����key����
		Set<Object> keySet = hashMap.keySet();
		for (Object object : keySet) {
			System.out.println(object);
		}
		System.out.println("==========================");
		//����value��collection
		Collection<Object> values = hashMap.values();
		for (@SuppressWarnings("unused") Object object : values) {
			System.out.println(values);
		}
		System.out.println("==========================");
		//�������е�key-value
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
		
		//TreeSet��keyֵ������һ��������Ķ���������key�����������������ͬ��������Ļ����ǰ���value
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
