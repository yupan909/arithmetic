package com.example.designPattern.facade;

/**
 * 智能控制器
 *
 * @author yupan
 * @date 7/10/21 4:55 PM
 */
public class SmartController {

    private AirCondition airCondition;
    private Light light;
    private TV tv;

    public SmartController() {
        airCondition = new AirCondition();
        light = new Light();
        tv = new TV();
    }

    public void open() {
        System.out.println("## 一键开启 ##");
        airCondition.on();
        light.on();
        tv.on();
    }

    public void close() {
        System.out.println("## 一键关闭 ##");
        airCondition.off();
        light.off();
        tv.off();
    }
}
