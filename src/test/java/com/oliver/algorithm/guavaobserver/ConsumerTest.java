package com.oliver.algorithm.guavaobserver;

import com.google.common.eventbus.EventBus;
import com.oliver.algorithm.jdkobserver.NumberModel;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GuavaEventBusTest.class})
class GuavaEventBusTest {

    @Before
    public void init() {
        System.out.println("执行初始化");
    }

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