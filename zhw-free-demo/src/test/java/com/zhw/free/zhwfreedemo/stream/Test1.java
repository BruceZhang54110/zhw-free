package com.zhw.free.zhwfreedemo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("zhangsan");
        strings.add("zhangsan1");
        strings.add("zhangsan2");
        strings.add("zhangsan3");
        List list = strings.stream().map(s -> {
                    return s.toCharArray();

                }
        ).collect(Collectors.toList());
        System.out.println(list);
    }
}
