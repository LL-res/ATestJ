package com.github.llres.designpattern.chainOfResponsibility;

public abstract class Handler {
    private Handler nextHandler;

    public final void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    //这其实是个模板
    final boolean handle() {
        boolean handled = doHandle();
        //把链上的所有handler都执行一遍
//        if (nextHandler != null) {
//            return nextHandler.handle();
//        }
        //只执行一个为true的handler
        if (!handled && nextHandler != null){
            return nextHandler.handle();
        }
        return handled;
    }

    abstract boolean doHandle();
}
