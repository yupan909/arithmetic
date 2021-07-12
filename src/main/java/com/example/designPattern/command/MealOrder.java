package com.example.designPattern.command;

/**
 * 饭菜下单
 *
 * @author yupan
 * @date 7/12/21 6:12 PM
 */
public class MealOrder extends Order {

    public MealOrder(Worker worker) {
        super(worker);
    }

    @Override
    public void need() {
        System.out.println("来一份小炒肉");
        super.getWorker().action();
    }
}
