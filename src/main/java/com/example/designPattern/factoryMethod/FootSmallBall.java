package com.example.designPattern.factoryMethod;

/**
 * 足球
 *
 * @author yupan
 * @date 7/2/21 4:55 PM
 */
public class FootSmallBall implements Ball {

    @Override
    public void play() {
        System.out.println("小号足球");
    }
}
