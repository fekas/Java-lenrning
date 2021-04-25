package com.zhongbin.collections;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

/**
 * Collections是操作Collection和Map的工具类
 * 里面的方法只能静态调用
 * @author XiaoBin
 * 2020年9月4日上午12:35:43
 */
public class CollectionsTest {
	@Test
	public void test01() throws Exception {
		List<Object> list = new ArrayList<>();
		
/*
 * 		Collections.reverse(list);		反转
		Collections.shuffle(list);		随机处理
		Collections.sort(list);
		Collections.swap(list, 1, 2);
		Collections.max(Collection);
		Collections.frequency(list, "123");		出现频率
错误写法	List dest = new ArrayList<>();		destination list
正确		List dest = Arrays.asList(new Object[list.size()]);
		Collections.copy(dest , list);			dest的长度必须大于list的长度	
		Collections.synchronizedxxx()方法可以把线程不安全的方法转成线程安全的方法
*/
		
	}

}
