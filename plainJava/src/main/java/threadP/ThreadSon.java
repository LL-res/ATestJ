package threadP;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class ThreadSon extends Thread{
    private Integer i = 0;
    @Override
    public void run(){
        for (int j = 0; j < 5; j++) {
            i++;
        }
    }
    public static void eeece(){
        System.out.println("eeece");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSon threadSon = new ThreadSon();
        threadSon.start();
        new ThreadSon().start();
        new ThreadSon().start();
        new ThreadSon().start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(threadSon.getI());
    }
}
