package threadP;

public class FooBarPrinter {
    private int n;
    private Thread fooThread;
    private Thread barThread;

    public FooBarPrinter(int n) {
        this.n = n;
    }

    public void printFoo() {
        System.out.print("foo");
    }

    public void printBar() {
        System.out.print("bar");
    }

    public void startThreads() {
        Runnable fooTask = () -> {
            try {
                for (int i = 0; i < n; i++) {
                    printFoo();
                    if (barThread != null) {
                        barThread.join(); // 等待bar线程执行完毕
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable barTask = () -> {
            try {
                for (int i = 0; i < n; i++) {
                    printBar();
                    if (fooThread != null) {
                        fooThread.join(); // 等待foo线程执行完毕
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        fooThread = new Thread(fooTask);
        barThread = new Thread(barTask);

        fooThread.start();
        barThread.start();
    }

    public static void main(String[] args) {
        FooBarPrinter printer = new FooBarPrinter(5);
        printer.startThreads();
    }
}
