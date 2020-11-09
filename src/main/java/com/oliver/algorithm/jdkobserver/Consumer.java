package com.oliver.algorithm.jdkobserver;

import cn.hutool.core.lang.Console;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = false)
public class Consumer implements Observer {
    private int number;
    private String name;

    public Consumer(int number){
        this.number = number;
        name = String.valueOf(System.nanoTime());
    }

    @Override
    public void update(Observable o, Object arg) {
        NumberModel numberModel = (NumberModel) arg;
        if (numberModel.getNumber() != number){
            Console.log("{}号码不匹配，继续排队中。。。。。。",number);
            return;
        }
        Console.log("排到我们-{}-了，前往 {} 用餐",number,numberModel.getDeskType());
    }
}
