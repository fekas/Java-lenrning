package com.zhongbin.enumerate;


public class CreateEnumBefore5 {
	public Season spring = Season.SPRING;
}

//�Զ���ö����
class Season{
	//1.����Season��������ԣ��Ƽ���private final����
	private final String seasonName;
	private final String seasonDesc;
	
	//2.˽�л��������������������Գ�ʼ��
	private Season(String seasonName, String seasonDesc) {
		super();
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	//3.�ṩ��ǰö����Ķ��������public static final����
	public static final Season SPRING = new Season("����","��ů����");
	public static final Season SUMMER = new Season("����","��������");
	public static final Season AUTUMN = new Season("����","�����ˬ");
	public static final Season WINTER = new Season("����","����ѩ��");

	//����1.��ȡö������������
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	
	//����2���ṩtoString����
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	
}
