package com.oliver.algorithm.jdkobserver;

import org.junit.jupiter.api.Test;

class CallNumberSystemTest {

  @Test
  void notifyNumber() {
      Consumer consumerA = new Consumer(10001);
      Consumer consumerB = new Consumer(10002);
      Consumer consumerC= new Consumer(10003);
      Consumer consumerD= new Consumer(10001);

      CallNumberSystem instance = CallNumberSystem.getInstance();
      instance.addObserver(consumerA);
      instance.addObserver(consumerB);
      instance.addObserver(consumerC);
      instance.addObserver(consumerD);

      instance.notifyNumber(new NumberModel(10001,"A1234桌"));
  }
}