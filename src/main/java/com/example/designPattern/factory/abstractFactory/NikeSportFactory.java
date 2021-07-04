package com.example.designPattern.factory.abstractFactory;

import com.example.designPattern.factory.Ball;
import com.example.designPattern.factory.BasketBall;

/**
 * 耐克体育工厂
 *
 * @author yupan
 * @date 7/4/21 2:40 PM
 */
public class NikeSportFactory implements SportFactory{

    @Override
    public Ball createBall() {
        return new BasketBall();
    }

    @Override
    public Shirt createShirt() {
        return new LongShirt();
    }
}
