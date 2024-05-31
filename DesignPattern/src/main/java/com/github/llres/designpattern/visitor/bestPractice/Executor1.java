package com.github.llres.designpattern.visitor.bestPractice;

//要新加功能直接再写个类实现Visitor，然后把各个产品都处理一遍
public class Executor1 implements Visitor{
    @Override
    public void handle(Product1 product1) {
        //实现executor1对于product1要实现的功能
    }

    @Override
    public void handle(Product2 product2) {
        //实现executor1对于product2要实现的功能
    }
}
