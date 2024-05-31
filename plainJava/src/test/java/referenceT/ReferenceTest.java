package referenceT;

import org.junit.jupiter.api.Test;

import java.lang.ref.*;

public class ReferenceTest {
    @Test
    void t1(){
        // 强引用
        String strongReference = "abc";
        // 软引用
        //只要JVM内存不足就会回收软引用，因此软引用可以用在缓存中
        //如果内存够就集训缓存，如果不够GC也会直接释放这个内存
        SoftReference<String> softReference = new SoftReference<String>("缓存的内容");
        if (softReference.get() != null){
            System.out.println(softReference.get());
        }else{
            softReference = new SoftReference<>("新获取的内容");
            System.out.println(softReference.get());
        }

    }

    @Test
    void t2() {
        //先在堆中开辟一块内存
        String str = new String("abc");
        //弱引用跟软引用的不同在于，弱引用只要一有GC出现就会被回收，不管内存是否充足
        WeakReference<String> weakReference = new WeakReference<>(str);
        //解除掉这个强引用，让这个内存上只有一个弱引用
        str = null;
        System.out.println(weakReference.get());
        //如果用一个强引用再次标记这个内存，则在GC时不会被回收（试试把下面的注释去掉前后的区别）
        //String strongAgain = weakReference.get();
        System.gc();
        System.out.println(weakReference.get());
    }

    @Test
    void t3() throws InterruptedException {
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        WeakReference<String> a = new WeakReference<>(new String("a"), queue);
        WeakReference<String> b = new WeakReference<>(new String("a"), queue);
        WeakReference<String> c = new WeakReference<>(new String("a"), queue);
        WeakReference<String> d = new WeakReference<>(new String("a"), queue);
        System.out.println(queue.poll());
        System.gc();
        Thread.sleep(1000);
        System.out.println("a :" + a.get());
        //只要有引用所指向的内存被垃圾回收了，那么这个引用就会被放入这个queue中
        //注意：只是引用被放入了队列，内存内容还是被回收了
        for (;;){
            Reference<? extends String> poll = queue.poll();
            if (poll == null){
                break;
            }else{
                System.out.println(poll);
                System.out.println(poll.get());
            }
        }
    }

    @Test
    void t4() {
        //虚引用加在一个对象上，这个对象相当与没有多出任何引用
        //虚引用必须配合这个队列一起使用，用于追踪这个对象的垃圾回收情况
        String s = new String("abc");
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        PhantomReference<String> stringPhantomReference = new PhantomReference<>(s,queue);
    }
}
