package com.github.llres.designpattern.proxy;

public class StaticProxy implements BaseOrigin{
    private final BaseOrigin origin;
    public StaticProxy(){
        origin = new Origin();
    }
    @Override
    public void doSomething() {
        System.out.println("StaticProxy do before proxy");
        origin.doSomething();
        System.out.println("StaticProxy do after proxy");
    }

    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.doSomething();
    }
}
