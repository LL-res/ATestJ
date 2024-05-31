package com.github.llres.designpattern.chainOfResponsibility;

public class HandlerChain {
    private Handler handlerHead;
    private Handler handlerTail;

    public void addHandler(Handler handler) {
        if (handlerHead == null) {
            handlerHead = handler;
            handlerTail = handler;
        }else{
            handlerTail.setNextHandler(handler);
            handlerTail = handler;
        }
    }
    public boolean work(){
        if (handlerHead != null){
            return handlerHead.handle();
        }
        return false;
    }
}
