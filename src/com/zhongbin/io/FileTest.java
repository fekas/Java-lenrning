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
 * File类的使用(见file文档)
 * 
 * File的一个实例代表一个文件或者文件夹
 * @author XiaoBin
 * 2020年9月20日下午8:19:16
 */
public class FileTest{
	
	/**
	 * File的实例化
	 * 创建File实例:四个构造器
	 * 
	 * 相对路径：
	 * 绝对路径：
	 */
	@Test
	public void test01() throws Exception {
		/**
		 * 构造器1：File(String);
		 */
		File file01 =new File("hello.txt");	//相对路径
		/**
		 * 路径分隔符:
		 * Windows和DOS分隔符"\"
		 * UNIX和URL分隔符"/"
		 * 为了兼容性可以使用File类中的separate常量来代替分隔符如:
		 * "C:"+File.separate+"Users"+File.separate+"HP"+File.separate+"Desktop"+File.separate+"Code"+File.separate+"SSM"+File.separate+"Spring
		 */
		File file02 = new File("C:\\Users\\HP\\Desktop\\Code\\SSM\\Spring\\note.txt");	//绝对路径
		
		System.out.println(file01);
		System.out.println(file02);
		
		/**
		 * 构造器2:File(String,String);
		 */
		File file03 = new File("C:","fileTest");
		System.out.println(file03);
		
		/**
		 * 构造器3File(File,String);
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
