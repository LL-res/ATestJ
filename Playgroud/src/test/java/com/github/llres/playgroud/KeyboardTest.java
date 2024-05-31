package com.github.llres.playgroud;

import com.github.llres.playgroud.capture.ClipboardOperator;
import com.github.llres.playgroud.capture.GlobalKeyListener;
import com.google.common.eventbus.EventBus;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class KeyboardTest {
    @Test
    public void t1() {
        try {
            // 启动全局键盘监听器
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("Failed to register native hook: " + ex.getMessage());
            System.exit(1);
        }

        // 添加键盘事件监听器
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener(new EventBus()));
    }
    @Test
    public void t2() throws IOException, UnsupportedFlavorException, InterruptedException, AWTException {
        TimeUnit.SECONDS.sleep(2);
        ClipboardOperator.insertSelectedContent();
        System.out.println(ClipboardOperator.readContent());
    }
    @Test
    public void t3() throws InterruptedException {
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            System.out.println(systemClipboard.getData(DataFlavor.stringFlavor));
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
