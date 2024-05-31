package com.github.llres.designpattern.singleton;

//饿汉式，如果多个线程一起getInstance会导致并发度下降为1，性能低
public class Singleton1 {
    private static Singleton1 instance;

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
