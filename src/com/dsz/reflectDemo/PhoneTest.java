package com.dsz.reflectDemo;

import java.lang.reflect.Method;

public class PhoneTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> p = Class.forName("com.dsz.reflectDemo.Phone");
		Method[] methods = p.getMethods();
		System.out.println(methods);
		Phone mp = (Phone)p.newInstance();
		mp.call();
	}

}
