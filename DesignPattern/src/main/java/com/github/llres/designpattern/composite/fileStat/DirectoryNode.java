package com.github.llres.designpattern.composite.fileStat;

import lombok.Data;

import java.io.File;
import java.util.Arrays;


public class DirectoryNode extends Node {

    public long size() {
        File[] files = file.listFiles();
        if (files == null) return 0;
        return Arrays.stream(files).map(f -> {
            if (f.isDirectory()) {
                return new DirectoryNode(f).size();
            } else {
                return new FileNode(f).size();
            }
        }).reduce(0L, Long::sum);
    }

    public DirectoryNode(File file) {
        super(file);
    }

}
