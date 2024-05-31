package com.github.llres.designpattern.composite;

//组合模式用在树状结构中，可以把数中的元素分为两类
//一类是单纯的一个节点
//一类是包含了更多节点的一个集合
//这样就可以在类似递归的时候无需写终止条件，简化代码，增加易读性
public interface TreeElement {
    Integer countNode();
}
