package com.oliver.algorithm.guavaobserver;

import com.google.common.eventbus.EventBus;
import com.oliver.algorithm.jdkobserver.NumberModel;
import org.junit.jupiter.api.Test;

class GuavaEventBusTest {

    @Test
    public void callNumberModel(){
        Consumer consumerA = new Consumer(10001);
        Consumer consumerB = new Consumer(10002);
        Consumer consumerC = new Consumer(10003);
        Consumer consumerD = new Consumer(10001);

        EventBus eventBus = new EventBus("CallNumberSystem");
        eventBus.register(consumerB);
        eventBus.register(consumerA);
        eventBus.register(consumerC);
        eventBus.register(consumerD);

        eventBus.post(new NumberModel(10001,"A1234桌"));

    }
}