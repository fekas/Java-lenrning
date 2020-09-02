package com.zhongbin.enumerate;

/**
 * 用enum关键字定义枚举类
 * 定义枚举类默认继承于java.lang.Enum类
 * Enum类提供的主要方法
 * 	1.toString返回枚举类对象的名称。
 * 	2.values
 * 	3.valuesOf
 * @author XiaoBin
 * 2020年9月1日上午8:50:39
 */
public class CreateEnumByKeyWord {
	
}

enum SeasonByKeyWord implements Info{
	
	//1.提供当前枚举类的对象，多个对象之间用逗号隔开，末尾分号结束。
	//2.每一个对象都可以重写接口里的方法
	SPRING("春天","春暖花开"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("where is the spring?");
		}
	},
	SUMMER("夏天","夏日炎炎"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}
	},
	AUTUMN("秋天","秋高气爽"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}
	},
	WINTER("冬天","冰天雪地"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}
	};
	
	//2.申明Season对象的属性，推荐用private final修饰
	private final String seasonName;
	private final String seasonDesc;
	
	//2.私有化构造器，并给对象属性初始化
	private SeasonByKeyWord(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	//诉求1.获取枚举类对象的属性
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	//诉求2：提供toString方法
	//java.lang.Enum已经提供了toString方法。作用是输出名字

	/*
	 * 1.在这里统一写一个方法
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}*/
}


//使用枚举类实现接口
//1.
//2.让每一个接口各自实现接口里的方法
 interface Info{
	 public void show();
 }
