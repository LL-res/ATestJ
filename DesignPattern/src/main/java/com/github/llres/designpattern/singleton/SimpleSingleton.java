package com.github.llres.designpattern.singleton;

//简单的饿汉式
public class SimpleSingleton {
    private static final SimpleSingleton instance = new SimpleSingleton();

    public static SimpleSingleton getInstance() {
        return instance;
    }
}
