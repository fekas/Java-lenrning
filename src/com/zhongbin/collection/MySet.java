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
 * Ԫ������ ���洢�������ڵײ㲢�ǰ��������˳����ӣ��ǰ������ݵ�hashֵѡ����ӵ�λ��
 * �����ظ���֤��ӵ�Ԫ�ذ���equals�����ж�ʱ���ܷ���true
 * 
 * Ԫ����ӹ��̣�
 * ����Ԫ��Hashֵ�� ͨ��ĳ���㷨������λ�ã��жϸ�λ����û��Ԫ�أ���û��Ԫ�أ����Ԫ�ء�
 * ��Ԫ����Ƚ�hashֵ�����hashֵ��ͬ�����Ԫ�أ�hashֵ��ͬ������equals�����Ƚ�����Ԫ�أ�
 * �������true��֤��Ԫ����ͬ������ӣ�����false����ӡ�������ķ�ʽ�ڸ�λ�ô��档1.8�Ժ�����ӵ�Ԫ����headλ�ã�1.8��ǰ��tailλ��
 * 
 * 
 * ��set��������ݣ������ڵ��������дhashCode()������equals()�����Ҿ����ܱ���һ���ԣ�����ͬ�Ķ�������ͬ��hashֵ
 * 
 * �ײ㣺����+����
 * @author XiaoBin
 * 2020��9��3������10:15:02
 */
public class MySet {

	//�ӿڵ���Ҫʵ���࣬�̲߳���ȫ�����Դ�null
	Set<Object> hashSet = new HashSet<>();
	//HashSet�����ࣨ���ָ�룩���������ڲ�����ʱ���԰�������ӵ�˳�����
	Set<Object> linkedhashSet = new LinkedHashSet<>();
	//Ҫ����ӵ����ݶ���ͬһ����Ķ�������Ҫʵ��comparable�ӿڣ����԰�����Ӷ���ָ�����Խ�������
	//��Ϊ�ײ���һ������������ԱȽϵ�������ͬ��comparable����0�����޷��Ž�ȥ
	//��comparable�ӿڵ�compareTo��������0����TreeSet����Ѹ�Ԫ����ӵ�set��
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
		
		//����������
		Iterator<Object> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		//��ǿforѭ��
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
		
		
		//��ʽ
		TreeSet<User> treeSet2 = new TreeSet<>(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}
}
