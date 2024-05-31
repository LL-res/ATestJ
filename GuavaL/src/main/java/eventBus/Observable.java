package eventBus;

import com.google.common.eventbus.EventBus;

public class Observable {
    private EventBus eventBus = new EventBus();

    public void reister(Object object) {
        eventBus.register(object);
    }
    public void post(Object event) {
        eventBus.post(event);
    }
}
