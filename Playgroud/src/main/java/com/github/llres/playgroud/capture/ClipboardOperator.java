package com.github.llres.playgroud.capture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ClipboardOperator {
    private static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private static final Logger log = LoggerFactory.getLogger(ClipboardOperator.class);
    private static String snapshotContent;

    public static String readContent() {
        try {
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (IOException e) {
            log.error("io error " + e.getMessage());
        } catch (UnsupportedFlavorException e) {
            log.error("unsupported " + e.getMessage());

        }

        return "defaultContent";
    }

    public static void setContent(String content) {
        clipboard.setContents(new StringSelection(content), null);
    }

    public static void recover() {
        if (snapshotContent != null) {
            setContent(snapshotContent);
        }
    }

    public static void snapshot() {
        snapshotContent = readContent();
    }

    public static void insertSelectedContent() {
        try {
            KeyboardBot.keyIn(KeyEvent.VK_CONTROL, KeyEvent.VK_C);
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
