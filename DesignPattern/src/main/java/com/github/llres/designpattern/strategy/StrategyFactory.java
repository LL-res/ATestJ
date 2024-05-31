package com.github.llres.designpattern.strategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class StrategyFactory {
    private static HashMap<String,Class<?>> strategyHashMap = new HashMap<>();
    //弱国策略是有状态的，那么就可以在map里加入class
    //如果是无状态的，那么直接在map里加对象就行了
    static {
        strategyHashMap.put("strategy1",Strategy1.class);
        strategyHashMap.put("strategy2", Strategy2.class);
    }
    public static Strategy getStrategy(String strategyName) throws NoSuchStrategyException {
        Class<?> aClass = strategyHashMap.get(strategyName);
        if (aClass==null) {
            throw new NoSuchStrategyException();
        }
        try {
            Constructor<?> constructor = aClass.getConstructor();
            Strategy o = (Strategy)constructor.newInstance();
            return o;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new NoSuchStrategyException();
        }
    }
    public static class NoSuchStrategyException extends Exception {}
}
