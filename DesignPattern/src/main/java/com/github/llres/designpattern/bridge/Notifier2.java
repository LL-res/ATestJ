package com.github.llres.designpattern.bridge;

public class Notifier2 extends Notifier{
    public Notifier2(MsgSender sender) {
        super(sender);
    }

    @Override
    void notify(String message) {
        System.out.println("Notifier2 start");
        this.sender.send(message);
        System.out.println("Notifier2 end");

    }
}
