package threadP;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

@Data
@AllArgsConstructor
public class CrossPrint implements Runnable {
    private Integer n;
    private LinkedBlockingQueue<Object> takeFrom;
    private LinkedBlockingQueue<Object> putTo;
    private String content;

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            try {
                takeFrom.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(content);
            try {
                putTo.put(new Object());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    static final Object lock = new Object();
    static class Worker1 extends Thread{
        private final String content;
        private final Thread partner;
        public  Worker1(String content,Thread partner){
            this.content = content;
            this.partner = partner;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.print(content);
                try {
                    partner.join();
                } catch (InterruptedException ignored) {
                    System.out.println("interrupt");
                }
            }
        }
    }
    static class Worker2 extends Thread{
        private final String content;
        public  Worker2(String content){
            this.content = content;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (lock){
                    System.out.print(content);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        LinkedBlockingQueue<Object> foo = new LinkedBlockingQueue<>(1);
//        LinkedBlockingQueue<Object> bar = new LinkedBlockingQueue<>(1);
//        foo.put(new Object());
//        new Thread(new CrossPrint(5, foo, bar, "foo")).start();
//        new Thread(new CrossPrint(5, bar, foo, "bar")).start();
        Worker2 bar = new Worker2("bar");
        Worker1 foo = new Worker1("foo", bar);
        foo.start();
        bar.start();
    }
}
