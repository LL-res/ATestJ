package com.github.llres.designpattern.bridge;

public class MsgSender2 implements MsgSender{
    @Override
    public void send(String msg) {
        System.out.println("MsgSender2");
    }
}
