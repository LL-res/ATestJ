package com.github.llres.designpattern.factory;
//如果想要产出的东西需要复杂的创建过程则可以使用工厂方法模式，使用一个工厂来创建复杂对象的工厂，再由对象工厂创建复杂对象
//把对象的复杂创建逻辑从单个工厂中移出
public class MethodFactory {
    public ComplexProduct createComplexProduct(String productName)throws Exception {
        //此处可以进一步考虑优化，再创建一个FactoryMap类，然后把这些工厂用静态代码块注册到Map中，
        // 获取的时候直接从那个Map类中get就行了
        ComplexProductFactory factory = switch (productName) {
            case "1" -> new ComplexProductFactory1();
            case "2" -> new ComplexProductFactory2();
            default -> throw new Exception("unavailable product");
        };
        return factory.createComplexProduct();
    }
}

class ComplexProductFactory1 implements ComplexProductFactory {
    public ComplexProduct createComplexProduct() {
        return new ComplexProduct1();
    }
}

class ComplexProductFactory2 implements ComplexProductFactory {
    public ComplexProduct createComplexProduct() {
        return new ComplexProduct2();
    }
}
class ComplexProduct1 implements ComplexProduct{}
class ComplexProduct2 implements ComplexProduct{}

