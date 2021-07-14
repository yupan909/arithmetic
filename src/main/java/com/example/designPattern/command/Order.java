package com.example.designPattern.command;

/**
 * 下单（命令）
 *
 * @author yupan
 * @date 7/12/21 6:00 PM
 */
public abstract class Order {

    protected Worker worker;

    public Order(Worker worker) {
        this.worker = worker;
    }

    /**
     * 点餐
     */
    public abstract void need();
}
