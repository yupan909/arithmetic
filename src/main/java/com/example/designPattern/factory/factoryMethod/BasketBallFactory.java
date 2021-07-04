package com.example.designPattern.factory.factoryMethod;

import com.example.designPattern.factory.Ball;
import com.example.designPattern.factory.BasketBall;

/**
 * 篮球工厂类
 *
 * @author yupan
 * @date 7/2/21 7:07 PM
 */
public class BasketBallFactory implements BallFactory {

    @Override
    public Ball createBall() {
        return new BasketBall();
    }
}
