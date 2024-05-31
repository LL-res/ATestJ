package com.github.llres.designpattern.bridge;

public class Notifier1 extends Notifier{
    public Notifier1(MsgSender sender) {
        super(sender);
    }

    @Override
    void notify(String message) {
        System.out.println("Notifier1 start");
        this.sender.send(message);
        System.out.println("Notifier1 end");

    }
}
