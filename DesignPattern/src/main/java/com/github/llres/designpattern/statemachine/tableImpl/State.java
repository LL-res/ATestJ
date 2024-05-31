package com.github.llres.designpattern.statemachine.tableImpl;

public enum State {
    SMALL(0),
    FIRE(1);
    private final int value;

    State(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
