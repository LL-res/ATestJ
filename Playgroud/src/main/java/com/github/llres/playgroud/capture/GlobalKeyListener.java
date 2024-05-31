package com.github.llres.playgroud.capture;

import com.google.common.eventbus.EventBus;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class GlobalKeyListener implements NativeKeyListener {
    private EventBus eventBus;
    private int[] keys = new int[]{NativeKeyEvent.VC_CONTROL, NativeKeyEvent.VC_1};
    private boolean[] pressed = new boolean[keys.length];
    private boolean needAction = true;

    static {
        LogManager.getLogManager().reset();

        // Get the logger for "org.jnativehook" and set the level to off.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        for (int i = 0; i < keys.length; i++) {
            if (nativeKeyEvent.getKeyCode() == keys[i]) {
                pressed[i] = true;
            }
        }
        for (boolean p : pressed) {
            if (!p) {
                return;
            }
        }
        if (needAction) {
            ClipboardOperator.snapshot();
            ClipboardOperator.insertSelectedContent();
            String toTranslate = ClipboardOperator.readContent();
            eventBus.post(toTranslate);
            ClipboardOperator.recover();
            needAction = false;
        }

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        for (int i = 0; i < keys.length; i++) {
            if (nativeKeyEvent.getKeyCode() == keys[i]) {
                pressed[i] = false;
                needAction = true;
            }
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        // 不处理 keyTyped 事件
    }
    public GlobalKeyListener(EventBus eventBus) {
        this.eventBus = eventBus;
    }
    public void register(Object object) {
        eventBus.register(object);
    }
}
