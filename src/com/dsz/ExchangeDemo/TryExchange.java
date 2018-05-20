package com.dsz.ExchangeDemo;

import java.io.IOException;

public class TryExchange {
    public static void main(String[] args) throws IOException{
        String to = new String("test".getBytes("UTF-8"),"iso-8859-1");
        System.out.println(to);
    }
}
