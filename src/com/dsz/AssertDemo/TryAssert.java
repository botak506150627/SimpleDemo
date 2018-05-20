package com.dsz.AssertDemo;

public class TryAssert {
    public static void main(String[] args) {
        boolean isOpen = false;
        assert isOpen = true;
        System.out.println("断言是否开启"+isOpen);
        if (isOpen)
        {
            int value=-1;
            assert 0 < value:"value="+value;
        }
    }
}
