package com.github.llres.designpattern.visitor;

import java.util.ArrayList;

public class Executor1 {
    public  void handleProduct(Product1 product) {
        System.out.println("handleProduct1");
    }

    public  void handleProduct(Product2 product) {
        System.out.println("handleProduct2");
    }

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product1());
        products.add(new Product2());
        //下面注释的代码是会报错的
        //注意方法重载是静态绑定的
        //而多态则是可以进行动态识别出具体的类型的，也就是说在循环里使用product这个变量，来执行Product1或是2的特有方法是行的通的
//        for (Product product : products) {
//            Executor.handleProduct(product);
//        }
        Executor1 executor1 = new Executor1();
        for (Product product : products) {
            product.accept(executor1);
        }

    }
}
