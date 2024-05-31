package lockT;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    @Test
    public void t1() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread iMWaitingWorker = new Thread(() -> {
            lock.lock();
            try {
                condition.await();
                System.out.println("i m waiting worker");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("i finished waiting");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        });
        Thread iMNotifier = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("i m notifier");
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        });
        iMNotifier.setDaemon(false);
        iMWaitingWorker.setDaemon(false);
        iMWaitingWorker.start();
        Thread.sleep(1000);
        iMNotifier.start();
    }
}
