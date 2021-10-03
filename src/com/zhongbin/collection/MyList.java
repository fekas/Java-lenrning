package com.zhongbin.collection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * List����:�洢Ԫ�����򣬿��ظ�
 * @author XiaoBin
 * 2020��9��3������10:14:35
 */
public class MyList {
	//��ΪList�ӿڵ���Ҫʵ���࣬�̲߳���ȫ��Ч�ʸߣ�ʹ��Object[] elementData�洢
	//ArrayList��һ�ε���addʱ��������Ϊ10�����飬���Ԫ��ʱ����������������1.5��
	List<Object> arrayList = new ArrayList<>();
	//��ΪList�ӿڵĹ���ʵ���࣬�̰߳�ȫ��Ч�ʵͣ�ʹ��Object[] elementData�洢
	List<Object> v = new Vector<>();
	//�ײ�ʹ�õ�ʱ˫������洢������Ƶ���Ĳ���ɾ��������Ч�ʱ�ArrayList��
	List<Object> linkedList = new LinkedList<>();
	
	Queue<Object> queue = new LinkedList<Object>();
	
	
	
	@Test
	public void MyListTest() throws Exception {
		
		
		arrayList.add("12 3");
		arrayList.add(123);
		
		//1.��iterator����
		Iterator<Object> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		
		//2.��ǿforѭ�������ڱ�������򼯺�
		for (Object object : arrayList) {
			System.out.println(object);
		}
	}
	
	@Test
	public void testRemove() throws Exception {
		int index = 100;
		Object o = new String("123");
		
		arrayList.remove(index);//�Ƴ�index����ĳ��Ԫ��
		arrayList.remove(o);//�Ƴ�ĳ��Ԫ��
		
	}
	
	@Test
	public void testArray() {
		int[] a = new int[] {1, 2, 3};
		
		int[] copyOfRange = Arrays.copyOfRange(a, 0, 0);
		
		System.out.println(copyOfRange.length);
		
	}
}
