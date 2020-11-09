package com.oliver.algorithm.jdkobserver;

import java.util.Observable;

/**
 * @author Oliver Wang
 * @description 呼叫系统 被观察主题--单例
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/9
 * @since
 */
public class CallNumberSystem extends Observable {
    private CallNumberSystem(){}
    private volatile static CallNumberSystem callNumberSystem = null;

    public static CallNumberSystem getInstance(){
        if (callNumberSystem == null){
            synchronized (CallNumberSystem.class){
                if (callNumberSystem == null){
                    callNumberSystem = new CallNumberSystem();
                }
            }
        }
        return callNumberSystem;
    }

    /**
     * 叫号 通知观察者执行update方法
     * @param numberModel
     */
    public void notifyNumber(NumberModel numberModel){
        System.out.println("系统播报：请" + numberModel.getNumber() + "号顾客到" + numberModel.getDeskType() + "就餐！");
        setChanged();
        notifyObservers(numberModel);
    }
}
