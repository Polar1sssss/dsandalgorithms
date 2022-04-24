package com.hujtb.test;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.zip.ZipInputStream;

public class Test {
    public static void main(String[] args) {
//        Major m1 = new Major("电子");
//        Student s1 = new Student("zhangsan", 134333, m1);
//        Student s2 = s1.clone();
//        m1.setName("sss");
//        System.out.println(s1 + "" + s1.hashCode());
//        System.out.println(s2 + "" + s2.hashCode());
        String s1 = "saf";
        String s2 = new String("saf").intern();
        System.out.println(s1 == s2);
        // 如果常量池中有zzz，则在堆中创建一个对象没有就现在常量池中创建一个zzz然后在堆中在创建一个zzz
        String s3 = new String("zzz");

    }
}
