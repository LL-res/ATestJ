package com.github.llres.designpattern.visitor.bestPractice;

public abstract class Product {
    public abstract void accept(Visitor visitor);
}
