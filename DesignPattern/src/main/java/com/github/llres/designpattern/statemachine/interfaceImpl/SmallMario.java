package com.github.llres.designpattern.statemachine.interfaceImpl;

public class SmallMario implements IMario{
    @Override
    public void receiveEvent1(StateMachine stateMachine) {
        //进行状态的转移
        stateMachine.setCurrenMario(new FireMario());
        //进行action的触发
        //do some complex action
    }

    @Override
    public void receiveEvent2(StateMachine stateMachine) {

    }
}
