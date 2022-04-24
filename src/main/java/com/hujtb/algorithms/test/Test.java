package com.hujtb.algorithms.test;

class Father {
    int x = 10;
    public Father() {
        this.print();
        x = 20;
    }
    public void print() {
        System.out.println("Father:" + x);
    }
}

class Son extends Father {
    int x = 30;
    public Son() {
        this.print();
        x = 40;
    }
    public void print() {
        System.out.println("Son:" + x);
    }
}

public class Test {
    public static void main(String[] args) {
//        String s1 = new String("hello") + new String("world");
//        s1.intern();
//        String s2 = "helloworld";
//        System.out.println(s1 == s2);
        Father f = new Son();
        System.out.println(f.x);
    }
}
