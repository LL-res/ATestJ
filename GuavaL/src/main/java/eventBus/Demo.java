package eventBus;

public class Demo {
    public static void main(String[] args) {
        Observable observable = new Observable();
        Observer observer = new Observer();
        observable.post("msg");
    }
}
