package com.github.llres.designpattern.visitor;

public class Product2 extends Product{
    @Override
    public void accept(Executor1 executor) {
        executor.handleProduct(this);
    }
}
