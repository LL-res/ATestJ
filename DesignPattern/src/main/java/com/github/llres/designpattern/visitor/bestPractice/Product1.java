package com.github.llres.designpattern.visitor.bestPractice;

public  class Product1 extends Product{
    @Override
    public  void accept(Visitor visitor){
        visitor.handle(this);
    }
}
