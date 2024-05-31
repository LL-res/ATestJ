package com.github.llres.designpattern.composite;

public class SubTree implements TreeElement {
    private TreeElement rightElement;
    private TreeElement leftElement;

    @Override
    public Integer countNode() {
        return 1+ rightElement.countNode() + leftElement.countNode();
    }

    public void addRight(TreeElement element) {
        this.rightElement = element;
    }

    public void addLeft(TreeElement element) {
        this.leftElement = element;
    }
}
