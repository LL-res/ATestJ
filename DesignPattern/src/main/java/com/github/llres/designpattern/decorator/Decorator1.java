package com.github.llres.designpattern.decorator;

public class Decorator1 extends Origin{
    private Origin origin;
    public Decorator1(Origin origin) {
        this.origin = origin;
    }
    //与代理模式的不同是，装饰器模式实现的是对原有对象的功能增强，增加与原来功能类似的功能
    //而代理模式则是增加的一些辅助性的功能，与原有功能不类似
    @Override
    public void doSomething() {
        System.out.println("Decorator1 doSomething");
        this.origin.doSomething();
    }
}
