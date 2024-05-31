package com.github.llres.designpattern.statemachine.tableImpl;

public enum Event {
    EVENT1(0),
    EVENT2(1);
    final private int value;
    Event(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
