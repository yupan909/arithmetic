package com.example.designPattern.command;

/**
 * 厨师
 *
 * @author yupan
 * @date 7/12/21 6:20 PM
 */
public class CookWorker extends Worker{

    @Override
    public void action() {
        System.out.println("厨师准备炒菜");
    }
}
