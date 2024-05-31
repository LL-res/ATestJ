package com.github.llres.designpattern.visitor.bestPractice;

public interface Visitor {
    void handle(Product1 product1);
    void handle(Product2 product2);
    //要新加产品往这加
}
