package com.example.designPattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者
 *
 * @author yupan
 * @date 7/16/21 10:49 AM
 */
public class ConcreteMediator implements Mediator {

    private List<Customer> customerList = new ArrayList<>();

    /**
     * 添加客户
     * @param customer
     */
    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    /**
     * 转发消息
     * @param message
     * @param customer
     */
    @Override
    public void forward(String message, Customer customer) {
        for (Customer c : customerList) {
            // 如果是买方发布消息，则通知所有卖方
            if (customer instanceof Buyer) {
                if (c instanceof Seller) {
                    c.answer(message);
                }
            // 如果是卖方发布消息，则通知所有买方
            } else {
                if (c instanceof Buyer) {
                    c.answer(message);
                }
            }
        }
    }
}
