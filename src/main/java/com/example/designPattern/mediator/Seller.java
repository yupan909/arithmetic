package com.example.designPattern.mediator;

/**
 *
 * 房东（卖房者)
 * @author yupan
 * @date 7/16/21 10:58 AM
 */
public class Seller extends Customer {

    public Seller(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void answer(String message) {
        System.out.println("（房东）" + name + "收到消息：" + message);
    }
}
