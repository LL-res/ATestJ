package com.github.llres.designpattern.visitor.bestPractice;

public class Product2 extends Product{
    @Override
    public void accept(Visitor visitor) {
        visitor.handle(this);
    }
}
