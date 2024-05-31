package com.github.llres.designpattern.statemachine.interfaceImpl;

import lombok.Setter;

//当状态不多但action复杂的时候进行使用，应为每个状态都是一个类，如果状态一多就会引入特别多的类
public class StateMachine {
    @Setter
    private IMario currenMario;

    public void receiveEvent1() {
        currenMario.receiveEvent1(this);
    }

    public void receiveEvent2() {
        currenMario.receiveEvent2(this);
    }
}
