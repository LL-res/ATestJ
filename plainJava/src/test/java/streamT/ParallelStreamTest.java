package streamT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

public class ParallelStreamTest {
    @ParameterizedTest
    @MethodSource("testPools")
    public void t1(Executor pool) throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        if (pool != null) {
            pool.execute(() -> IntStream.rangeClosed(1, 5).parallel().forEach(i -> {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread() + "finish");
            }));
        }else{
            IntStream.rangeClosed(1, 5).parallel().forEach(i -> {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread() + "finish");
            });
        }

        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("time consumed : " + (end - start) / 1000);
    }
    //只有forkJoin pool能控制住parallel的并发度，使用其他线程池只能执行一次任务
    //parallel stream默认会把所有的cpu都占上，不要用在会阻塞的任务上
    public static List<Executor> testPools() {
        ArrayList<Executor> list = new ArrayList<>();
        list.add(new ForkJoinPool(1));
        list.add(new ForkJoinPool(2));
        list.add(Executors.newFixedThreadPool(1));
        list.add(Executors.newFixedThreadPool(2));
        list.add(null);
        return list;
    }
}
