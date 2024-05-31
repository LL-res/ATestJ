package com.github.llres.designpattern.statemachine.tableImpl;

public class StateMachine {
    private static final State[][] transitionTable = new State[][]{
            /////////////////*Event1*/   /*Event2*/
            /*SMALL*/       {State.FIRE, State.SMALL},
            /*FIRE*/        {State.SMALL, State.FIRE},
    };
    private State currentState;

    public StateMachine() {
        currentState = State.SMALL;
    }

    public void receiveEvent1() {
        executeEvent(Event.EVENT1);
        //还可以做一些简单的action
    }
    public void executeEvent(Event event){
        currentState = transitionTable[currentState.getValue()][event.getValue()];
    }
}
