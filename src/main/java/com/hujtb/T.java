package com.hujtb;

// 保护程序的安全性，防止核心api被篡改；避免类的重复加载，保证类的全局唯一性
public class T {
    // 按照顺序初始化静态成员变量->静态代码块
    public static int k = 0;
    public static T t1 = new T("t1");
    public static T t2 = new T("t2");
    public static int i = print("i");
    public static int n = 99;

    static {
        print("静态块");
    }

    public int j = print("j");

    {
        print("构造块");
    }

    public T(String str) {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + " i=" + i + " n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {

    }
}
