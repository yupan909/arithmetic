package com.example.designPattern.command;

/**
 * 服务员（命令调用者）
 *
 * @author yupan
 * @date 7/12/21 6:04 PM
 */
public class Waiter {

    private Order order;


    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * 通知后厨
     */
    public void call() {
        System.out.println("收到客户下单，通知后厨....");
        order.need();
    }

}
