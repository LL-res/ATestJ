package com.github.llres.playgroud.capture;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class KeyboardBot {
//    public static KeyboardBot then() {
//
//    }

    public void finish() {

    }

    public static void keyIn(int... keys) throws AWTException {
        Robot robot = new Robot();
        for (int key : keys) {
            robot.keyPress(key);
        }
        for (int i = keys.length - 1; i >= 0; i--) {
            robot.keyRelease(keys[i]);
        }
    }

    public void start() {

    }

    public static void main(String[] args) throws InterruptedException, AWTException {
        TimeUnit.SECONDS.sleep(5);
        keyIn(KeyEvent.VK_CONTROL, KeyEvent.VK_C);
    }
}
