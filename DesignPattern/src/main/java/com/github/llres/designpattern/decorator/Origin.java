package com.github.llres.designpattern.decorator;

public class Origin {
    public void doSomething() {
        System.out.println("Origin doSomething");
    }

    public static void main(String[] args) {
        Origin origin = new Origin();
        Decorator1 decorator1 = new Decorator1(origin);
        decorator1.doSomething();
        new Decorator2(origin).doSomething();
    }
}
