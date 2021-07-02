package com.example.designPattern.factoryMethod.simpleFactory;

/**
 * 篮球
 *
 * @author yupan
 * @date 7/2/21 4:55 PM
 */
public class BasketBall implements Ball{

    @Override
    public void play() {
        System.out.println("打篮球");
    }
}
