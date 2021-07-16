package com.example.designPattern.mediator;

/**
 * 客户抽象类
 *
 * @author yupan
 * @date 7/16/21 10:51 AM
 */
public abstract class Customer {

    /**
     * 客户名称
     */
    protected String name;

    /**
     * 中介
     */
    protected Mediator mediator;

    public Customer(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    /**
     * 客户的需求
     * @param message
     */
    public void need(String message) {
        System.out.println(name + ": " + message);
        // 交给中介转发
        mediator.forward(message, this);
    }

    /**
     * 收到回复
     * @param message
     */
    public abstract void answer(String message);
}
