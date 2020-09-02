package com.zhongbin.annotation;

/**
 * 创建自定义注解
 * 自定义直接需要配上注解处理信息的流程（反射）才有意义
 * 自定义直接通常都会指定@Retention @Target两个元注解
 * @author XiaoBin
 * 2020年9月1日上午10:55:46
 */

/**
 * 元注解：修饰注解的注解
 * @Retention			指定annotation的生命周期:SOURCE/CLASS(default)/RUNTIME
 * 									只有申明为RUNTIME生命周期的才可以通过反射获取
 * @Target				自定被修饰的annotation可以修饰那些元素
 * 
 * @Documented			表示所修饰的直接在javadoc解析时保留
 * @Inherited			表示被修饰的类有继承性，父类被修饰子类也会被修饰
 * 
 * 通过反射获取注解信息
 * 
 * jdk1.8注解新特性：
 * 	1.可重复性注解
 * 	2.类型注解
 */
public @interface MyAnnotation {
	//成员变量以无参的方法的形式来申明
	String value() default "HELLO";
}
