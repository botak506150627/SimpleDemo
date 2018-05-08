package com.dsz.ThreadDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> sylist = Collections.synchronizedList(list);
    }
}
