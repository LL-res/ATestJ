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
}
