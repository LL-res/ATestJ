package com.github.llres.designpattern.template;

public abstract class AbstractClass {
    //写成final防止被子类重写这个方法
    final public void templateMethod() {
        System.out.println("first step");
        method1();
        System.out.println("second step");
        method2();
    };
    abstract void method1();
    abstract void method2();
}
