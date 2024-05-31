package com.github.llres.designpattern.decorator;

public class Decorator2 extends Origin{
    private Origin origin;
    public Decorator2(Origin origin){
        this.origin = origin;
    }

    @Override
    public void doSomething() {
        System.out.println("Decorator2 doSomething");
        this.origin.doSomething();
    }
}
