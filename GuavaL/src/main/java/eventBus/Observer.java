package eventBus;

import com.google.common.eventbus.Subscribe;

public class Observer {
    @Subscribe
    public void msgReceived(Object event){
        System.out.println("received event");
    }
}
