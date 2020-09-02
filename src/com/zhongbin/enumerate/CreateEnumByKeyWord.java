package com.zhongbin.enumerate;

/**
 * ��enum�ؼ��ֶ���ö����
 * ����ö����Ĭ�ϼ̳���java.lang.Enum��
 * Enum���ṩ����Ҫ����
 * 	1.toString����ö�����������ơ�
 * 	2.values
 * 	3.valuesOf
 * @author XiaoBin
 * 2020��9��1������8:50:39
 */
public class CreateEnumByKeyWord {
	
}

enum SeasonByKeyWord implements Info{
	
	//1.�ṩ��ǰö����Ķ��󣬶������֮���ö��Ÿ�����ĩβ�ֺŽ�����
	//2.ÿһ�����󶼿�����д�ӿ���ķ���
	SPRING("����","��ů����"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("where is the spring?");
		}
	},
	SUMMER("����","��������"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}
	},
	AUTUMN("����","�����ˬ"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}
	},
	WINTER("����","����ѩ��"){
		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}
	};
	
	//2.����Season��������ԣ��Ƽ���private final����
	private final String seasonName;
	private final String seasonDesc;
	
	//2.˽�л��������������������Գ�ʼ��
	private SeasonByKeyWord(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	//����1.��ȡö������������
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	//����2���ṩtoString����
	//java.lang.Enum�Ѿ��ṩ��toString�������������������

	/*
	 * 1.������ͳһдһ������
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}*/
}


//ʹ��ö����ʵ�ֽӿ�
//1.
//2.��ÿһ���ӿڸ���ʵ�ֽӿ���ķ���
 interface Info{
	 public void show();
 }
