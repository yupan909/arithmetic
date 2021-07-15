package com.example.designPattern.observer;

/**
 * 主题抽象类
 *
 * @author yupan
 * @date 7/15/21 3:52 PM
 */
public interface Subject {

    /**
     * 添加观察者
     * @param observer
     */
    void add(Observer observer);

    /**
     * 移除观察者
     * @param observer
     */
    void remove(Observer observer);

    /**
     * 通知所有观察者
     * @param message
     */
    void notify(String message);
}
