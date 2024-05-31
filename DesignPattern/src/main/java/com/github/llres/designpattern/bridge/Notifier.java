package com.github.llres.designpattern.bridge;

public abstract class Notifier {
    protected final MsgSender sender;
    public Notifier(MsgSender sender) {
        this.sender = sender;
    }
    abstract void notify(String message);
}
