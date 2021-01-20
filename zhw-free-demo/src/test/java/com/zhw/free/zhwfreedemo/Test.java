package com.zhw.free.zhwfreedemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        String a = "209911";
        LocalDate l = LocalDate.parse(a, DateTimeFormatter.ofPattern("yyyyMd"));
        System.out.println(l);
    }
}
