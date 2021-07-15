package com.example.designPattern.observer;

/**
 * 观察者类
 *
 * @author yupan
 * @date 7/15/21 3:59 PM
 */
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " 收到了动态：" + message);
    }
}
