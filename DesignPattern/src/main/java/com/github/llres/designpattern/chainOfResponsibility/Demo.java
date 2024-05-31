package com.github.llres.designpattern.chainOfResponsibility;

public class Demo {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        Handler h1 = new Handler() {
            @Override
            boolean doHandle() {
                System.out.println("1 false");
                return false;
            }
        };
        Handler h2 = new Handler() {
            @Override
            boolean doHandle() {
                System.out.println("2 true");
                return true;
            }
        };
        Handler h3 = new Handler() {
            @Override
            boolean doHandle() {
                System.out.println("3 true");
                return true;
            }
        };
        handlerChain.addHandler(h1);
        handlerChain.addHandler(h2);
        handlerChain.addHandler(h3);
        handlerChain.work();
    }
}
