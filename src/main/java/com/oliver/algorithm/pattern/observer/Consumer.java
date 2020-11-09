package com.oliver.algorithm.pattern.observer;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Oliver Wang
 * @description 观察者
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/9
 * @since 
 */
@Data
public class Consumer implements Observer {
    private int number;

    public Consumer(int number){
        this.number = number;
    }

    @Override
    public void update(Observable o, Object arg) {
        NumberModel numberModel = (NumberModel) arg;
        if (numberModel.getNumber() != number){
            System.out.println("号码不匹配，继续排队中。。。。。。");
        }
        System.out.println("排到我们了，前往" + numberModel.getDeskType() + "用餐");
    }
}
