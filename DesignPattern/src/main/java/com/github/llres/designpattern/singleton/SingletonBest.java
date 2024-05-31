package com.github.llres.designpattern.singleton;

//SingletonHolder 是一个静态内部类，当外部类 IdGenerator 被加载的时候，
// 并不会创建SingletonHolder 实例对象。只有当调用 getInstance() 方法时，
// SingletonHolder 才会被加载，这个时候才会创建 instance。insance 的唯一性、
// 创建过程的线程安全性，都由JVM 来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载。
public class SingletonBest {
    private static SingletonBest instance;

    private static class InstanceHolder {
        private static final SingletonBest instance = new SingletonBest();
    }

    public static SingletonBest getInstance() {
        return InstanceHolder.instance;
    }
}
