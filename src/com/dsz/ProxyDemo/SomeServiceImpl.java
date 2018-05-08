package com.dsz.ProxyDemo;

public class SomeServiceImpl implements DoSomeService{
    @Override
    public String dofirst() {
        System.out.println("1");
        return "abcd";
    }

    @Override
    public void dosecond() {
        System.out.println("2");
    }
}
