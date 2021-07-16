package com.example.designPattern.mediator;

/**
 *
 * 买方（买房者)
 * @author yupan
 * @date 7/16/21 10:58 AM
 */
public class Buyer extends Customer {

    public Buyer(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void answer(String message) {
        System.out.println("（买方）" + name + "收到消息：" + message);
    }
}
