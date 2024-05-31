package com.github.llres.playgroud;

import com.github.llres.playgroud.dictionary.DicClient;
import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;

public class ClientTest {
    @Test
    public void t1(){
        DicClient dicClient = new DicClient(new EventBus());
        dicClient.sendWord("example");
    }
}
