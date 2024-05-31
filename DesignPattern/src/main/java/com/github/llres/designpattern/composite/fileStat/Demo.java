package com.github.llres.designpattern.composite.fileStat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //String prefix = "C:\\Users\\LL\\AppData\\Local\\Packages";
        String prefix = "C:\\Users\\LL\\Desktop\\W\\gf";
        Node node = new Node(prefix);
        System.out.println(node.size()/1024/1024);
        node.getStat().stream().forEach(System.out::println);
    }
}
