package com.dsz.ClassLoaderDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader  myClassLoader = new MyClassLoader("D:\\lib");
        Class c = myClassLoader.loadClass("com.dsz.ClassLoaderDemo.Hello");
        if(c != null){
            Object o = c.newInstance();
            Method method = c.getMethod("sayHello",null);
            method.invoke(o,null);
            System.out.println(c.getClassLoader().toString());
        }
    }
}
