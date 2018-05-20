package com.dsz.ReflectionDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReclection {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class c = Some.class;
        Object o = c.newInstance();
        Method[] methods  = c.getMethods();
        Method[] dmethods = c.getDeclaredMethods();
        for(Method m:methods)
            System.out.println(m);
        for(Method dm:dmethods)
            System.out.println(dm);
        Method f = c.getMethod("outf");
        String result = (String) f.invoke(o);
        System.out.println(result);
    }
}
