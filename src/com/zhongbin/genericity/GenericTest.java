package com.zhongbin.genericity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhongbin.bean.User;

/**
 * ���ͣ�jdk1.5����������
 * �ڳ��������һЩ�������Ͳ��������ͣ�Ҳ����˵���͵Ĳ���ֻ���Դ����࣬���ܴ���������
 * �����ڶ����࣬�ӿ�ʱͨ��һ���ı�ʶ��ʾ���е�ĳ�����Ե����ͻ�����ĳ�������ķ���ֵ�����������͡�������Ͳ�����ʹ��ʱȷ��
 * @author XiaoBin
 * 2020��9��16������8:37:00
 */
public class GenericTest{

	@Test
	public void testInCollection() throws Exception {
		//�ڼ�����ʹ�÷����ü���ֻ�ܴ洢ָ��һ�����͵Ķ���
		List<User> ulist = new ArrayList<>();
		ulist.add(new User("QAQ",1,"QAQ@qq.com"));
		
	}
	
	//������ʱ����ӷ�������(�����ȼ�)Object���ʹ���
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
	 * ͨ���?��ʹ��
	 * ����List<?>�����������������(null����)�������Զ���������ݣ����ض���ΪObject
	 * ��A����B�ĸ��࣬G<A>��G<B>��û�й�ϵ�ģ����߹�ͬ�ĸ�����G<?>
	 * 
	 * ������������ͨ���
	 * ? extends ClassName	ʹ��ʱָ�������ͱ���̳�ClassName
	 * ? super ClassName	ʹ��ʱָ�������Ͳ���С�ڲ�������
	 * ? extends Comparable	ֻ������Ϊʵ��Comparable�ӿڵ�ʵ��������
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
