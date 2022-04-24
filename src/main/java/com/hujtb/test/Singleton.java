package com.hujtb.test;

public class Singleton {

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    private Singleton() {}

    public Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
