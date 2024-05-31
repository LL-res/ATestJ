package com.github.llres.designpattern.template;

public class ConcreteClass extends AbstractClass{
    @Override
    void method2() {
        System.out.println("ConcreteClass.method2()");
    }

    @Override
    void method1() {
        System.out.println("ConcreteClass.method1()");
    }

    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.templateMethod();
    }
}
