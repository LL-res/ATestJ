package com.github.llres.designpattern.factory;
//当产出物的创建逻辑简单时可以直接在一个工厂里面new出这个对象
public class SimpleFactory {
    public SimpleProduct createProduct(String productName) throws Exception {
        return switch (productName) {
            case "SimpleProduct1" -> new SimpleProduct1();
            case "SimpleProduct2" -> new SimpleProduct2();
            default -> throw new Exception("unavailable product");
        };
    }
}

class SimpleProduct1 implements SimpleProduct {

}

class SimpleProduct2 implements SimpleProduct {

}
