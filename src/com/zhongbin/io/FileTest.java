package com.zhongbin.io;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * File���ʹ��(��file�ĵ�)
 * 
 * File��һ��ʵ������һ���ļ������ļ���
 * @author XiaoBin
 * 2020��9��20������8:19:16
 */
public class FileTest{
	
	/**
	 * File��ʵ����
	 * ����Fileʵ��:�ĸ�������
	 * 
	 * ���·����
	 * ����·����
	 */
	@Test
	public void test01() throws Exception {
		/**
		 * ������1��File(String);
		 */
		File file01 =new File("hello.txt");	//���·��
		/**
		 * ·���ָ���:
		 * Windows��DOS�ָ���"\"
		 * UNIX��URL�ָ���"/"
		 * Ϊ�˼����Կ���ʹ��File���е�separate����������ָ�����:
		 * "C:"+File.separate+"Users"+File.separate+"HP"+File.separate+"Desktop"+File.separate+"Code"+File.separate+"SSM"+File.separate+"Spring
		 */
		File file02 = new File("C:\\Users\\HP\\Desktop\\Code\\SSM\\Spring\\note.txt");	//����·��
		
		System.out.println(file01);
		System.out.println(file02);
		
		/**
		 * ������2:File(String,String);
		 */
		File file03 = new File("C:","fileTest");
		System.out.println(file03);
		
		/**
		 * ������3File(File,String);
		 */
		File file04 = new File(file03,"hi.txt");
		System.out.println(file04);
	}
	
	
	
	@Test
	public void test02() throws Exception {
		
		MyFileFilter myFileFilter = new MyFileFilter();
		MyFileNameFilter myFileNameFilter = new MyFileNameFilter();
		
		File file01 = new File("C:\\Users\\HP\\Desktop\\Code\\SSM\\Spring");
		
		List<File> fileList = Arrays.asList(file01.listFiles(myFileNameFilter));
		
		for (File file : fileList) {
			System.out.println(file);
		}
	}
	
	
}
