package com.github.llres.designpattern.bridge;

public class MsgSender1 implements MsgSender{
    @Override
    public void send(String msg) {
        System.out.println("MsgSender1");
    }
}
