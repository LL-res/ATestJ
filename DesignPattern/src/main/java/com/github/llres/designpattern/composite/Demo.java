package com.github.llres.designpattern.composite;

public class Demo {
    public static void main(String[] args) {
        SubTree lowerTree = new SubTree();
        lowerTree.addRight(new Node());
        lowerTree.addLeft(new Node());
        SubTree upperTree = new SubTree();
        upperTree.addRight(lowerTree);
        upperTree.addLeft(lowerTree);
        System.out.println(upperTree.countNode());
    }
}
