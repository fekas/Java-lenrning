package com.zhongbin.annotation;

/**
 * �����Զ���ע��
 * �Զ���ֱ����Ҫ����ע�⴦����Ϣ�����̣����䣩��������
 * �Զ���ֱ��ͨ������ָ��@Retention @Target����Ԫע��
 * @author XiaoBin
 * 2020��9��1������10:55:46
 */

/**
 * Ԫע�⣺����ע���ע��
 * @Retention			ָ��annotation����������:SOURCE/CLASS(default)/RUNTIME
 * 									ֻ������ΪRUNTIME�������ڵĲſ���ͨ�������ȡ
 * @Target				�Զ������ε�annotation����������ЩԪ��
 * 
 * @Documented			��ʾ�����ε�ֱ����javadoc����ʱ����
 * @Inherited			��ʾ�����ε����м̳��ԣ����౻��������Ҳ�ᱻ����
 * 
 * ͨ�������ȡע����Ϣ
 * 
 * jdk1.8ע�������ԣ�
 * 	1.���ظ���ע��
 * 	2.����ע��
 */
public @interface MyAnnotation {
	//��Ա�������޲εķ�������ʽ������
	String value() default "HELLO";
}
