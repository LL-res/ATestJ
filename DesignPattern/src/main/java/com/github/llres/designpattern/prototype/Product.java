package com.github.llres.designpattern.prototype;

import java.io.*;

public class Product implements Base{
    //里面包含一些复杂的属性，如果直接初始化这个属性可能需要读数据库之类的，这时候就可以直接
    // 根据现有对象来创建一个新的对象
    @Override
    public Product clone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Product)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Product product = new Product();
        Product clone = product.clone();
    }
}
