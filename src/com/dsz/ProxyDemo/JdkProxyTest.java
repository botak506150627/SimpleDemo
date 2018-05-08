package com.dsz.ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        DoSomeService tar = new SomeServiceImpl();
        DoSomeService ss = (DoSomeService) Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = method.invoke(tar,args);
                if(result != null){
                    result = result.toString().toUpperCase();
                }
                return result;
            }
        });
        String result = ss.dofirst();
        System.out.println(result);
        ss.dosecond();
    }
}
