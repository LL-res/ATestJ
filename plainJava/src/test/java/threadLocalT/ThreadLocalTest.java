package threadLocalT;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    //ThreadLocal相当于线程中的全局变量，只有本线程可见其中内容
    //每个Thread的中都有一个list，这个list中包含了许多ThreadLocal
    //ThreadLocal在set时就是在当前线程中的list中加入这个ThreadLocal
    //在get时就是在当前线程中的ThreadLocal list中找到这个ThreadLocal然后取出对应的值
    @Test
    public void t1(){
        ThreadLocal<String> mStringThreadLocal = new ThreadLocal<>();
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                mStringThreadLocal.set("local variable in thread");
                System.out.println(mStringThreadLocal.get());
            }
        };
        t.start();
    }
}
