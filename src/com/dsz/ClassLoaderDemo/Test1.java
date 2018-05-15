package com.dsz.ClassLoaderDemo;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(Test1.class.getClassLoader().toString());
        System.out.println(Test1.class.getClassLoader().getParent().toString());
        System.out.println(Test1.class.getClassLoader().getParent().getParent().toString());
    }
}
