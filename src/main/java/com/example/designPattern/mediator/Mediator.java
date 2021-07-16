package com.example.designPattern.mediator;

/**
 * 中介者
 *
 * @author yupan
 * @date 7/16/21 10:49 AM
 */
public interface Mediator {

    /**
     * 添加客户
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     * 转发消息
     * @param message
     * @param customer
     */
    void forward(String message, Customer customer);
}
