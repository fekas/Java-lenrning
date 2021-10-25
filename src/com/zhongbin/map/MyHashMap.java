package com.zhongbin.map;

import java.util.HashMap;
import java.util.Map;

//debug HashMap
public class MyHashMap {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            map.put(i, "Hello" + i);
        }
    }
}
