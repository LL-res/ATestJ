package com.github.llres.designpattern.singleton;

//双重检测，一种对饿汉式的优化，把锁内移了，所有方法不会都去抢锁
//并且有两个对象同时执行第9行时，也只能有一个对象成功初始化单例对象
public class Singleton2 {
    private static Singleton2 instance;

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
