package ThreadT;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class FutureTest {
    @Test
    public void t1() throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> callable = new Callable<>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return "result";
            }
        };
        FutureTask<String> stringFutureTask = new FutureTask<>(callable);
        //需要一个Thread来运行才能获取到结果
        //new Thread(stringFutureTask).start();
        try {
            System.out.println(stringFutureTask.get(3,TimeUnit.SECONDS));
        }catch (TimeoutException e){
            System.out.println("time up");
        }
    }
    @Test
    public void t2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //提交到线程池的任务可以抛出异常，在get时可以try catch检查异常，如果不get，则会直接被吞掉异常
        Future<Object> task1 = executorService.submit(() -> {
            throw new Exception("msgError");
        });
        Future<String> task2 = executorService.submit(() -> "task2Result");
        try {
            System.out.println(task1.get());
        }catch (Exception e){
            System.out.println("catch the error");
        }
        try {
            System.out.println(task2.get());
        }catch (Exception e){
            System.out.println("catch the error");
        }

    }
}
