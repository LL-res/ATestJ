package com.github.llres.designpattern.bridge;

public class BuilderDemo {
    public static void main(String[] args) {
        //在这个例子中，notifier一系列就是抽象，sender一系列就是实现
        //桥接模式强调将抽象与实现分离，使两边都能独立的扩展
        //抽象实现就站在桥的两边，而桥就是它们间的组合关系
        //通过组合它们可以产生很多行为不同的实例
        Notifier notifier11 = new Notifier1(new MsgSender1());
        Notifier notifier12 = new Notifier1(new MsgSender2());
        Notifier notifier21 = new Notifier2(new MsgSender1());
        Notifier notifier22 = new Notifier2(new MsgSender2());
        notifier11.notify("msg");
        notifier12.notify("msg");
        notifier21.notify("msg");
        notifier22.notify("msg");
    }
}
