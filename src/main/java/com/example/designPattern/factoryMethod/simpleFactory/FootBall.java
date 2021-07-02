package com.example.designPattern.factoryMethod.simpleFactory;

import com.example.designPattern.factoryMethod.Ball;

/**
 * 足球
 *
 * @author yupan
 * @date 7/2/21 4:55 PM
 */
public class FootBall extends Ball {

    @Override
    public void play() {
        System.out.println("踢足球");
    }
}
