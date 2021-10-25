package com.zhongbin.jvm.classloader;

import java.io.InputStream;

public class MyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader myLoader01 = new ClassLoader() {
            /**
             * Loads the class with the specified <a href="#name">binary name</a>.
             * This method searches for classes in the same manner as the {@link
             * #loadClass(String, boolean)} method.  It is invoked by the Java virtual
             * machine to resolve class references.  Invoking this method is equivalent
             * to invoking {@link #loadClass(String, boolean) <tt>loadClass(name,
             * false)</tt>}.
             *
             * @param name The <a href="#name">binary name</a> of the class
             * @return The resulting <tt>Class</tt> object
             * @throws ClassNotFoundException If the class was not found
             */
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);

                    if(is == null){
                        //System.out.println("InputStream is null, + " + fileName);
                        return super.loadClass(name);
                    }
                    byte b[] = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (Exception e){
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        ClassLoader myLoader02 = new ClassLoader() {
            /**
             * Finds the class with the specified <a href="#name">binary name</a>.
             * This method should be overridden by class loader implementations that
             * follow the delegation model for loading classes, and will be invoked by
             * the {@link #loadClass <tt>loadClass</tt>} method after checking the
             * parent class loader for the requested class.  The default implementation
             * throws a <tt>ClassNotFoundException</tt>.
             *
             * @param name The <a href="#name">binary name</a> of the class
             * @return The resulting <tt>Class</tt> object
             * @throws ClassNotFoundException If the class could not be found
             * @since 1.2
             */
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);

                    if(is == null){
                        //System.out.println("InputStream is null, + " + fileName);
                        return super.loadClass(name);
                    }
                    byte b[] = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (Exception e){
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        //字节码文件和类要在自定义类加载器所在包下，不然getResourceAsStream()找不到class文件会交给上级加载器加载
        //Object obj01 = myLoader01.loadClass("com.zhongbin.jvm.BeanDemo").newInstance();
        Object obj02 = myLoader02.loadClass("com.zhongbin.jvm.classloader.BeanDemo").newInstance();

        /**
         * output:
         * class com.zhongbin.jvm.BeanDemo
         * false
         * 因为每个类加载器都有自己的命名空间，所以j不同的类加载器加载出来的类jvm不认为是同一个。
         * 产生问题：一个类被不同的类加载器加载或者其他类似情况会给程序带来混乱。所以我们需要一个限定名的类被一个类加载器加载并解析使用，
         *          以避免歧义。
         * 解决方法：双亲委派
         */
        //System.out.println(obj01.getClass());
        //System.out.println(obj01 instanceof com.zhongbin.jvm.BeanDemo);Object obj = myLoader01.loadClass("com.zhongbin.jvm.BeanDemo").newInstance();

        /**
         * output:
         * class com.zhongbin.jvm.BeanDemo
         * false
         * 因为每个类加载器都有自己的命名空间，所以j不同的类加载器加载出来的类jvm不认为是同一个。
         * 产生问题：一个类被不同的类加载器加载或者其他类似情况会给程序带来混乱。所以我们需要一个限定名的类被一个类加载器加载并解析使用，
         *          以避免歧义。
         * 解决方法：双亲委派
         */
        System.out.println(obj02.getClass().getClassLoader());
        System.out.println(obj02 instanceof BeanDemo);


    }

}
