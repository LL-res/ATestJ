package com.github.llres.designpattern.composite.fileStat;

import java.io.File;

public class FileNode extends Node {

    @Override
    public long size() {
        return file.length();
    }

    public FileNode(File file) {
        super(file);
    }
}
