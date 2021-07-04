package com.example.designPattern.factory.abstractFactory;

import com.example.designPattern.factory.Ball;
import com.example.designPattern.factory.FootBall;

/**
 * 李宁体育工厂
 *
 * @author yupan
 * @date 7/4/21 2:40 PM
 */
public class LiNingSportFactory implements SportFactory{

    @Override
    public Ball createBall() {
        return new FootBall();
    }

    @Override
    public Shirt createShirt() {
        return new ShortShirt();
    }
}
