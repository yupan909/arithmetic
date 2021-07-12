package com.example.designPattern.command;

/**
 * 吧台
 *
 * @author yupan
 * @date 7/12/21 6:20 PM
 */
public class CounterWorker extends Worker{

    @Override
    public void action() {
        System.out.println("吧台准备酒水");
    }
}
