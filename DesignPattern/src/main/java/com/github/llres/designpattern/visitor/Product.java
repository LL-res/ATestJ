package com.github.llres.designpattern.visitor;

public abstract class Product {
    public abstract void accept(Executor1 executor);
    //如果要加新功能，就在这新加一个accept，accept的入参就是新加的那个功能的逻辑
}
