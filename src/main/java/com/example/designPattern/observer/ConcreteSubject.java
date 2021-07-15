package com.example.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题类
 *
 * @author yupan
 * @date 7/15/21 3:52 PM
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    /**
     * 添加观察者
     * @param observer
     */
    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知所有观察者
     * @param message
     */
    @Override
    public void notify(String message) {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
