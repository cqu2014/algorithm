package com.oliver.algorithm.guavaobserver;

import cn.hutool.core.lang.Console;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.oliver.algorithm.jdkobserver.NumberModel;
import lombok.NoArgsConstructor;

/**
 * @author Oliver Wang
 * @description guava 使用 @Subscribe声明观察者对象的update方法
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/9
 * @since
 */
@NoArgsConstructor
public class Consumer {
    private int number;
    private String name;

    public Consumer(int number){
        this.number = number;
        name = String.valueOf(System.nanoTime());
    }

    @Subscribe
    @AllowConcurrentEvents
    public void update(NumberModel numberModel){
        if (numberModel.getNumber() != number){
            Console.log("{}号码不匹配，继续排队中。。。。。。",number);
            return;
        }
        Console.log("排到我们-{}-了，前往 {} 用餐",number,numberModel.getDeskType());
    }
}
