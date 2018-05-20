package com.dsz.ExceptionDemo;

public class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }

    public static void main(String[] args) {
        throw new MyException("测试");
    }
}
