package com.example.designPattern.factoryMethod.simpleFactory;

/**
 * 足球
 *
 * @author yupan
 * @date 7/2/21 4:55 PM
 */
public class FootBall implements Ball{

    @Override
    public void play() {
        System.out.println("踢足球");
    }
}
