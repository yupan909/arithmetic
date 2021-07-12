package com.example.designPattern.command;

/**
 * 酒水下单
 *
 * @author yupan
 * @date 7/12/21 6:12 PM
 */
public class DrinksOrder extends Order {

    private Worker worker;

    public DrinksOrder(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void need() {
        System.out.println("来一瓶雪碧");
        worker.action();
    }
}
