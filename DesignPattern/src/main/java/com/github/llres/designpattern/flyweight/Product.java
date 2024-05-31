package com.github.llres.designpattern.flyweight;

import lombok.AllArgsConstructor;

//当要创建很多的对象且对象中都包含一些不变的字段时
//可以把这些大家都会有的字段聚成一个单独的类
//就仿佛一个缓存，但与缓存不同的是，享元中是对有限数量的不变元素进行共享，强调的是节省空间
//而缓存强调的是提升速度
public class Product {
    private ImmutableElement immutableElement;
    private String mutableElement;

    public Product(String immutableElement, String mutableElement) {
        this.immutableElement = ImmutableElementFactory.getImmutableElement(immutableElement);
        this.mutableElement = mutableElement;
    }
}
