package com.github.llres.designpattern.strategy;

public class Demo {
    public static void main(String[] args) throws StrategyFactory.NoSuchStrategyException {
        Strategy strategy1 = StrategyFactory.getStrategy("strategy1");
        strategy1.doSomething();
    }
}
