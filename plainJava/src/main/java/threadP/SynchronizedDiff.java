package threadP;

import java.util.concurrent.TimeUnit;

/***
 * @author: G_night
 * 转载请声明作者
 * Reprint please state the author
 ***/
public class SynchronizedDiff {
    public static void main(String[] args) {
        PrintAB printAB = new PrintAB();
        new Thread(()->{
            printAB.A();
        },"a").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            printAB.B();
        },"b").start();
    }

}

class PrintAB{

    public synchronized static void A(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打印A");
    }
    public synchronized void B(){
        System.out.println("打印B");
    }
}


