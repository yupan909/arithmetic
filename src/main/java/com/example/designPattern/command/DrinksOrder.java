package com.example.designPattern.command;

/**
 * 酒水下单
 *
 * @author yupan
 * @date 7/12/21 6:12 PM
 */
public class DrinksOrder extends Order {

    public DrinksOrder(Worker worker) {
        super(worker);
    }

    @Override
    public void need() {
        System.out.println("来一瓶雪碧");
        super.getWorker().action();
    }
}
