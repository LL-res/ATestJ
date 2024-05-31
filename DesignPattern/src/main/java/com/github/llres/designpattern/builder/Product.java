package com.github.llres.designpattern.builder;

public class Product {
    private String field1;
    private String field2;
    //产品的构造函数需要是私有，防止不使用builder直接被构造出来
    private Product(Builder builder){
        this.field1 = builder.field1;
        this.field2 = builder.field2;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private String field1;
        private String field2;
        public Builder setField1(String field1){
            this.field1 = field1;
            return this;
        }
        public Builder setField2(String field2){
            this.field2 = field2;
            return this;
        }
        public Product build(){
            //此处可以做一些逻辑校验，看一看各个参数是否符合条件
            return new Product(this);
        }
    }

    public static void main(String[] args) {
        Product product = Product.builder().setField1("field1").setField2("field2").build();
    }
}
