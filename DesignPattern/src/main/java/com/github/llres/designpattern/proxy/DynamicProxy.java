package com.github.llres.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static BaseOrigin create(BaseOrigin baseOrigin){
        DynamicHandler dynamicHandler = new DynamicHandler(baseOrigin);
        Class<?>[] interfaces = baseOrigin.getClass().getInterfaces();
        return (BaseOrigin) Proxy.newProxyInstance(baseOrigin.getClass().getClassLoader(),interfaces,dynamicHandler);
    }
    private static class DynamicHandler implements InvocationHandler{
        private BaseOrigin baseOrigin;
        public DynamicHandler(BaseOrigin baseOrigin){
            this.baseOrigin = baseOrigin;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("dynamicProxy do before proxy");
            method.invoke(baseOrigin,args);
            System.out.println("dynamicProxy do after proxy");
            return proxy;
        }
    }

    public static void main(String[] args) {
        BaseOrigin baseOrigin = DynamicProxy.create(new Origin());
        baseOrigin.doSomething();
    }
}
