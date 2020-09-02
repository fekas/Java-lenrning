package com.zhongbin.enumerate;


public class CreateEnumBefore5 {
	public Season spring = Season.SPRING;
}

//自定义枚举类
class Season{
	//1.申明Season对象的属性，推荐用private final修饰
	private final String seasonName;
	private final String seasonDesc;
	
	//2.私有化构造器，并给对象属性初始化
	private Season(String seasonName, String seasonDesc) {
		super();
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	//3.提供当前枚举类的多个对象用public static final修饰
	public static final Season SPRING = new Season("春天","春暖花开");
	public static final Season SUMMER = new Season("夏天","夏日炎炎");
	public static final Season AUTUMN = new Season("秋天","秋高气爽");
	public static final Season WINTER = new Season("冬天","冰天雪地");

	//诉求1.获取枚举类对象的属性
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	
	//诉求2：提供toString方法
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	
}
